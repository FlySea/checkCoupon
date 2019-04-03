package com.datalink.checkcoupon.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.activity.MainActivity;
import com.datalink.checkcoupon.ui.adapter.CouponAdapter;
import com.datalink.checkcoupon.ui.model.CheckErrorBean;
import com.datalink.checkcoupon.ui.model.CouponBean;
import com.datalink.checkcoupon.ui.net.CheckService;
import com.datalink.checkcoupon.ui.net.CouponService;
import com.datalink.checkcoupon.ui.utils.PreferenceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.datalink.checkcoupon.ui.activity.MainActivity.EXTRA_ID;
import static com.datalink.checkcoupon.ui.activity.MainActivity.PAGER_COUPON_DETAIL;
import static com.datalink.checkcoupon.ui.activity.MainActivity.REQUEST_SCAN_CODE;
import static com.datalink.checkcoupon.ui.utils.PreferenceUtils.ACCOUNT_INFO;

public class CouponFragment extends BaseFragment implements View.OnClickListener {

    public static final int POSITION_INIT = 0;
    public static final int POSITION_ALREADY = 1;
    public static final int POSITION_PENDING = 2;
    MainActivity mActivity;
    RecyclerView mRecyclerView;
    TextView mAlreadyCheck;
    View mAlreadyIndicator;
    TextView mPendingCheck;
    View mPendingIndicator;
    ImageView mScan;
    PreferenceUtils mPreferenceUtils;
    int mPosition = POSITION_INIT;
    String mToken;
    LinearLayoutManager mLinearLayoutManager;
    CouponAdapter mCouponAdapter;

    CouponService mCouponService;
    CheckService mCheckService;
    Retrofit mRetrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
            .addConverterFactory(GsonConverterFactory.create()).build();

	Retrofit mCheckRetrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
			.addConverterFactory(GsonConverterFactory.create()).build();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCouponService = mRetrofit.create(CouponService.class);
        mCheckService = mCheckRetrofit.create(CheckService.class);
        mPreferenceUtils = new PreferenceUtils(getContext());
        mActivity = ((MainActivity) getActivity());
        mToken = mPreferenceUtils.getString(ACCOUNT_INFO, "");
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coupon, container, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mAlreadyCheck = view.findViewById(R.id.already_check);
        mPendingCheck = view.findViewById(R.id.pending_check);
        mAlreadyIndicator = view.findViewById(R.id.indicator_already);
        mPendingIndicator = view.findViewById(R.id.indicator_prepare);
        mScan = view.findViewById(R.id.scan);
        initView();
        initAdapter();
		inflateAlreadyData();
        return view;
    }

	private void initView() {
        mAlreadyCheck.setOnClickListener(this);
        mPendingCheck.setOnClickListener(this);
        mScan.setOnClickListener(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
    }

    private void initAdapter() {
    	mCouponAdapter = new CouponAdapter(getContext());
    	mCouponAdapter.setCouponListener(new CouponAdapter.CouponListener() {
			@Override
			public void onItemClick(String id) {
				Log.d("flysea", "mCouponAdapter onItemClick id = " + id);
				Bundle bundle = new Bundle();
				bundle.putString(EXTRA_ID, id);
				mActivity.changePager(PAGER_COUPON_DETAIL, bundle, false);
			}
		});
    	mRecyclerView.setAdapter(mCouponAdapter);
	}

    private void inflateAlreadyData() {
        if (mPosition == POSITION_ALREADY) {
            return;
        }
		mRecyclerView.removeAllViews();
		mCouponAdapter.setDataList(null);
		getCouponData("CONSUMED");
        mAlreadyIndicator.setVisibility(View.VISIBLE);
        mPendingIndicator.setVisibility(View.INVISIBLE);


        mPosition = POSITION_ALREADY;
    }

    private void getCouponData(String status) {
		Call<ResponseBody> call = mCouponService.getCoupon(status,"1", mToken);
		call.enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				Gson gson = new Gson();
				try {
					String responseStr = response.body().string();
					Log.d("flysea", "getCouponData responseStr " + responseStr);
					java.lang.reflect.Type type = new TypeToken<CouponBean>() {}.getType();
					CouponBean couponBean = gson.fromJson(responseStr, type);

					if ( couponBean == null || couponBean.getData() == null || couponBean.getData().getData() == null) {
						Toast.makeText(getContext(),"数据解析异常", Toast.LENGTH_LONG).show();
						return;
					}

					List<CouponBean.DataBeanX.DataBean> dataBeanList = couponBean.getData().getData();
					if (dataBeanList != null && dataBeanList.size() > 0 ) {
						mCouponAdapter.setDataList(dataBeanList);
					}
				} catch (IOException e) {
					e.printStackTrace();
					Toast.makeText(getContext(),"数据解析异常", Toast.LENGTH_LONG).show();
				}
			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				Toast.makeText(getContext(),"数据异常", Toast.LENGTH_LONG).show();
			}
		});
	}

    private void inflatePendingData() {
        if (mPosition == POSITION_PENDING) {
            return;
        }
		mRecyclerView.removeAllViews();
        mCouponAdapter.setDataList(null);
		getCouponData("CREATED");
        mAlreadyIndicator.setVisibility(View.INVISIBLE);
        mPendingIndicator.setVisibility(View.VISIBLE);


        mPosition = POSITION_PENDING;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.already_check:
                inflateAlreadyData();
                break;
            case R.id.pending_check:
                inflatePendingData();
                break;
			case R.id.scan:
				if (hasCameraPermission()){
					Intent intent = new Intent(getContext(), CaptureActivity.class);
					this.startActivityForResult(intent, REQUEST_SCAN_CODE);
				} else {
					ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.CAMERA},0);
				}
				break;
        }
    }

    private boolean hasCameraPermission() {
    	return !ActivityCompat.shouldShowRequestPermissionRationale(mActivity,Manifest.permission.CAMERA);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_SCAN_CODE) {
			if (null != data) {
				Bundle bundle = data.getExtras();
				if (bundle == null) {
					return;
				}
				if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
					String result = bundle.getString(CodeUtils.RESULT_STRING);
					Log.d("flysea", "flysea scan result : "+result);
					processCheck(result);
					//Toast.makeText(getContext(), "flysea scan result : "+result , Toast.LENGTH_SHORT).show();
				} else if(bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED){
					Toast.makeText(getContext(), "scan error" , Toast.LENGTH_SHORT).show();
					Log.d("flysea", "flysea scan error");
				}
			}
		}
	}

	private void processCheck(String numberStr) {
		final Gson gson = new Gson();
		HashMap<String, String> parasMaps = new HashMap<>();
		parasMaps.put("number", numberStr);
		String strEntity = gson.toJson(parasMaps);
		final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), strEntity);
		Call<ResponseBody> call = mCheckService.postConsume(requestBody, mToken);
		call.enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				try {
					Gson gs = new Gson();
					String responseStr = response.body().string();
					if (responseStr.contains("err_code")) {
						java.lang.reflect.Type type = new TypeToken<CheckErrorBean>() {}.getType();
						CheckErrorBean errorBean = gs.fromJson(responseStr, type);
						if (errorBean !=null && !TextUtils.isEmpty(errorBean.getMsg())) {
							Toast.makeText(getContext(),"核销失败：" + errorBean.getMsg(),Toast.LENGTH_LONG).show();
						}

					} else {
						Toast.makeText(getContext(),"核销成功",Toast.LENGTH_LONG).show();
					}
				} catch (IOException e) {
					e.printStackTrace();
					Toast.makeText(getContext(),"扫码解析异常", Toast.LENGTH_SHORT).show();
				}

			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				Toast.makeText(getContext(),"扫码结果异常", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
