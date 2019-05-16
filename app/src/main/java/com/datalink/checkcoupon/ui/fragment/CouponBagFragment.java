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
import com.datalink.checkcoupon.ui.adapter.CouponBagAdapter;
import com.datalink.checkcoupon.ui.model.CouponBagBean;
import com.datalink.checkcoupon.ui.net.CouponService;
import com.datalink.checkcoupon.ui.utils.ErrorMsg;
import com.datalink.checkcoupon.ui.utils.PreferenceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.datalink.checkcoupon.ui.activity.MainActivity.EXTRA_SCAN_NUM;
import static com.datalink.checkcoupon.ui.activity.MainActivity.PAGER_COUPON_DETAIL;
import static com.datalink.checkcoupon.ui.activity.MainActivity.PAGER_LOGIN;
import static com.datalink.checkcoupon.ui.activity.MainActivity.REQUEST_SCAN_CODE;
import static com.datalink.checkcoupon.ui.utils.PreferenceUtils.ACCOUNT_INFO;

public class CouponBagFragment extends BaseFragment implements View.OnClickListener {

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
    ImageView mCircle;
    TextView mChangeShop;
    TextView mTimeSpace;
    PreferenceUtils mPreferenceUtils;
    int mPosition = POSITION_INIT;
    String mToken;
    LinearLayoutManager mLinearLayoutManager;
    CouponBagAdapter mCouponAdapter;

    CouponService mCouponService;

    Retrofit mRetrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
            .addConverterFactory(GsonConverterFactory.create()).build();



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCouponService = mRetrofit.create(CouponService.class);
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
        mCircle = view.findViewById(R.id.circle);
        mChangeShop = view.findViewById(R.id.change_shop);
        mTimeSpace = view.findViewById(R.id.time_space);
        initView();
        initAdapter();
		inflateAlreadyData();
        return view;
    }

	private void initView() {
        mAlreadyCheck.setOnClickListener(this);
        mPendingCheck.setOnClickListener(this);
        mScan.setOnClickListener(this);
        mCircle.setOnClickListener(this);
        mChangeShop.setOnClickListener(this);
        mPendingCheck.setVisibility(View.GONE);
        mPendingIndicator.setVisibility(View.GONE);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
    }

    private void initAdapter() {
    	mCouponAdapter = new CouponBagAdapter(getContext());
//    	mCouponAdapter.setCouponListener(new CouponAdapter.CouponListener() {
//			@Override
//			public void onItemClick(String id) {
//				Log.d("flysea", "mCouponAdapter onItemClick id = " + id);
//				Bundle bundle = new Bundle();
//				bundle.putString(EXTRA_ID, id);
//				mActivity.changePager(PAGER_COUPON_DETAIL, bundle, false);
//			}
//		});
    	mRecyclerView.setAdapter(mCouponAdapter);
	}

    private void inflateAlreadyData() {
        if (mPosition == POSITION_ALREADY) {
            return;
        }
		mRecyclerView.removeAllViews();
		mCouponAdapter.setDataList(null);
		getCouponData();
        mAlreadyIndicator.setVisibility(View.VISIBLE);
        mPendingIndicator.setVisibility(View.INVISIBLE);


        mPosition = POSITION_ALREADY;
    }

    private void getCouponData() {
		Call<ResponseBody> call = mCouponService.getCouponBag(mToken);
		call.enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				Gson gson = new Gson();
				try {
					String responseStr = response.body().string();
					Log.d("flysea", "getCouponData responseStr " + responseStr);
					java.lang.reflect.Type type = new TypeToken<CouponBagBean>() {}.getType();
                    CouponBagBean couponBean = gson.fromJson(responseStr, type);

					if ( couponBean == null || couponBean.getData() == null || couponBean.getData().getData() == null) {
						if (!TextUtils.isEmpty(ErrorMsg.getErrMsg(responseStr))) {
							Toast.makeText(getContext(), ErrorMsg.getErrMsg(responseStr), Toast.LENGTH_LONG).show();
						}
						return;
					}

					List<CouponBagBean.DataBeanX.DataBean> dataBeanList = couponBean.getData().getData();
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

//    private void inflatePendingData() {
//        if (mPosition == POSITION_PENDING) {
//            return;
//        }
//		mRecyclerView.removeAllViews();
//        mCouponAdapter.setDataList(null);
//		getCouponData("CREATED");
//        mAlreadyIndicator.setVisibility(View.INVISIBLE);
//        mPendingIndicator.setVisibility(View.VISIBLE);
//
//
//        mPosition = POSITION_PENDING;
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.already_check:
                inflateAlreadyData();
                mTimeSpace.setText("核销时间");
                break;
            case R.id.pending_check:
                mTimeSpace.setText("兑换时间");
                //inflatePendingData();
                break;
			case R.id.scan:
				if (hasCameraPermission()){
					Intent intent = new Intent(getContext(), CaptureActivity.class);
					this.startActivityForResult(intent, REQUEST_SCAN_CODE);
				} else {
					ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.CAMERA},0);
				}
				break;
			case R.id.circle:
			case R.id.change_shop:
				mActivity.changePager(PAGER_LOGIN, null, false);
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
					Bundle arg = new Bundle();
					arg.putString(EXTRA_SCAN_NUM, result);
					mActivity.changePager(PAGER_COUPON_DETAIL, arg, false);
					//processCheck(result);
					//Toast.makeText(getContext(), "flysea scan result : "+result , Toast.LENGTH_SHORT).show();
				} else if(bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED){
					Toast.makeText(getContext(), "scan error" , Toast.LENGTH_SHORT).show();
					Log.d("flysea", "flysea scan error");
				}
			}
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if (mPosition == POSITION_ALREADY) {
            inflateAlreadyData();
        }
		else {
            //inflatePendingData();
        }
	}
}
