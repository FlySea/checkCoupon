package com.datalink.checkcoupon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.activity.MainActivity;
import com.datalink.checkcoupon.ui.adapter.GiftDetailAdapter;
import com.datalink.checkcoupon.ui.model.CouponBean;
import com.datalink.checkcoupon.ui.model.GiftDetailBean;
import com.datalink.checkcoupon.ui.net.GiftDetailService;
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

import static com.datalink.checkcoupon.ui.activity.MainActivity.EXTRA_ID;
import static com.datalink.checkcoupon.ui.activity.MainActivity.EXTRA_TYPE;
import static com.datalink.checkcoupon.ui.activity.MainActivity.PAGER_COUPON;
import static com.datalink.checkcoupon.ui.utils.PreferenceUtils.ACCOUNT_INFO;

public class GiftDetailListFragment extends BaseFragment implements View.OnClickListener {

    PreferenceUtils mPreferenceUtils;
    String mToken;
    LinearLayoutManager mLinearLayoutManager;
    GiftDetailAdapter mGiftDetailAdapter;
    MainActivity mActivity;
    RecyclerView mRecyclerView;
    String mType;
    String mId;
    TextView mBack;

    GiftDetailService mGiftDetailService;
    Retrofit mRetrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null ) {
            mType = getArguments().getString(EXTRA_TYPE);
            mId = getArguments().getString(EXTRA_ID);
        }
        mGiftDetailService = mRetrofit.create(GiftDetailService.class);
        mPreferenceUtils = new PreferenceUtils(getContext());
        mActivity = ((MainActivity) getActivity());
        mToken = mPreferenceUtils.getString(ACCOUNT_INFO, "");
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        getGiftDetialData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gift_detail_list, container, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        mBack = view.findViewById(R.id.back);
        initView();
        initAdapter();
        return view;
    }

    private void getGiftDetialData() {
        if (TextUtils.isEmpty(mType) || TextUtils.isEmpty(mId) || TextUtils.isEmpty(mToken)) {
            return;
        }
        Call<ResponseBody> call = mGiftDetailService.getCouponDetail(mType, mId, mToken);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                try {
                    String responseStr = response.body().string();
                    Log.d("flysea", "getCouponDetail responseStr " + responseStr);
                    java.lang.reflect.Type type = new TypeToken<GiftDetailBean>() {}.getType();
                    GiftDetailBean giftDetailBean = gson.fromJson(responseStr, type);

                    if ( giftDetailBean == null || giftDetailBean.getData() == null ) {
                        Toast.makeText(getContext(),"数据解析异常", Toast.LENGTH_LONG).show();
                        return;
                    }

                    List<GiftDetailBean.DataBean> dataBeanList = giftDetailBean.getData();
                    if (dataBeanList != null && dataBeanList.size() > 0 ) {
                        mGiftDetailAdapter.setDataList(dataBeanList);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),"数据解析异常", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(),"数据解析异常", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initAdapter() {
        mGiftDetailAdapter = new GiftDetailAdapter(getContext());
        mRecyclerView.setAdapter(mGiftDetailAdapter);
    }

    private void initView() {
        MainActivity parentActivity = (MainActivity) getActivity();
        parentActivity.setBottomTabVisibility(false);
        mBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                mActivity.changePager(PAGER_COUPON, null, true);
                break;
        }
    }
}
