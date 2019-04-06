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
import android.widget.Toast;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.activity.MainActivity;
import com.datalink.checkcoupon.ui.adapter.GiftAdapter;
import com.datalink.checkcoupon.ui.model.GiftBean;
import com.datalink.checkcoupon.ui.net.GiftService;
import com.datalink.checkcoupon.ui.utils.ErrorMsg;
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
import static com.datalink.checkcoupon.ui.activity.MainActivity.PAGER_COUPON_DETAIL;
import static com.datalink.checkcoupon.ui.activity.MainActivity.PAGER_GIFT_DETAIL;
import static com.datalink.checkcoupon.ui.utils.PreferenceUtils.ACCOUNT_INFO;

public class GiftFragment extends BaseFragment {

    MainActivity mActivity;
    RecyclerView mRecyclerView;
    PreferenceUtils mPreferenceUtils;
    String mToken;
    LinearLayoutManager mLinearLayoutManager;
    GiftAdapter mGiftAdapter;
    GiftService mGiftService;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGiftService = retrofit.create(GiftService.class);
        mPreferenceUtils = new PreferenceUtils(getContext());
        mActivity = ((MainActivity) getActivity());
        mToken = mPreferenceUtils.getString(ACCOUNT_INFO, "");
        mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        initAdapter();
        getGiftData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gift_list, container, false);
        mRecyclerView = view.findViewById(R.id.recycler);
        initView();
        return view;
    }

    private void getGiftData() {
        Call<ResponseBody> call = mGiftService.getGiftList(mToken);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                try {
                    String responseStr = response.body().string();
                    Log.d("flysea", "giftlist response :" + responseStr);
                    java.lang.reflect.Type type = new TypeToken<GiftBean>() {}.getType();
                    GiftBean giftBean = gson.fromJson(responseStr, type);

                    if ( giftBean == null || giftBean.getData() == null ) {
                        if (!TextUtils.isEmpty(ErrorMsg.getErrMsg(responseStr))) {
                            Toast.makeText(getContext(), ErrorMsg.getErrMsg(responseStr), Toast.LENGTH_LONG).show();
                        }
                        return;
                    }

                    List<GiftBean.DataBean> dataBeanList = giftBean.getData();
                    if (dataBeanList != null && dataBeanList.size() > 0) {
                        mGiftAdapter.setDataList(dataBeanList);
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

    private void initView() {
        MainActivity parentActivity = (MainActivity) getActivity();
        parentActivity.setBottomTabVisibility(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mGiftAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        getGiftData();
    }

    private void initAdapter() {
        mGiftAdapter = new GiftAdapter(getContext());
//        mGiftAdapter.setGiftListener(new GiftAdapter.GiftListener() {
//            @Override
//            public void onItemClick(String type, String id) {
//                Log.d("flysea", "mCouponAdapter onItemClick id = " + id);
//                Bundle bundle = new Bundle();
//                bundle.putString(EXTRA_ID, id);
//                bundle.putString(EXTRA_TYPE, type);
//                mActivity.changePager(PAGER_GIFT_DETAIL, bundle, false);
//
//            }
//        });
    }
}
