package com.datalink.checkcoupon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.activity.MainActivity;
import com.datalink.checkcoupon.ui.adapter.CouponAdapter;
import com.datalink.checkcoupon.ui.model.CouponBean;
import com.datalink.checkcoupon.ui.net.CouponService;
import com.datalink.checkcoupon.ui.utils.PreferenceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    PreferenceUtils mPreferenceUtils;
    int mPosition = POSITION_INIT;
    String mToken;
    LinearLayoutManager mLinearLayoutManager;
    CouponAdapter mCouponAdapter;

    CouponService mCouponService;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCouponService = retrofit.create(CouponService.class);
        mPreferenceUtils = new PreferenceUtils(getContext());
        mActivity = ((MainActivity) getActivity());
        mToken = mPreferenceUtils.getString(ACCOUNT_INFO, "");
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

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
        initView();
        initAdapter();
		inflateAlreadyData();
        return view;
    }

    private void initView() {
        mActivity = (MainActivity) getActivity();
        mActivity.setBottomTabVisibility(true);
        mAlreadyCheck.setOnClickListener(this);
        mPendingCheck.setOnClickListener(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
    }

    private void initAdapter() {
    	mCouponAdapter = new CouponAdapter(getContext());
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
        }
    }
}
