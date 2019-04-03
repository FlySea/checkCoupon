package com.datalink.checkcoupon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.activity.MainActivity;
import com.datalink.checkcoupon.ui.model.CouponDetailBean;
import com.datalink.checkcoupon.ui.net.CouponDetailService;
import com.datalink.checkcoupon.ui.utils.PreferenceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.datalink.checkcoupon.ui.activity.MainActivity.EXTRA_ID;
import static com.datalink.checkcoupon.ui.activity.MainActivity.PAGER_COUPON;
import static com.datalink.checkcoupon.ui.utils.PreferenceUtils.ACCOUNT_INFO;

public class CouponDetailFragment extends BaseFragment implements View.OnClickListener {

	PreferenceUtils mPreferenceUtils;
	MainActivity mActivity;
	TextView mBack;
	TextView mMemberInfo;
	TextView mPick_mode;
	ImageView mImage;
	TextView mName;
	TextView mCoins;
	TextView mStatus;
	TextView mTime;
	TextView mStock;
	Button mConfirm;
	String mToken;
	String mId;

	CouponDetailService mCouponDetailService;
	Retrofit mRetrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
			.addConverterFactory(GsonConverterFactory.create()).build();

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null ) {
			mId = getArguments().getString(EXTRA_ID);
		}
		mCouponDetailService = mRetrofit.create(CouponDetailService.class);
		mPreferenceUtils = new PreferenceUtils(getContext());
		mActivity = ((MainActivity) getActivity());
		mToken = mPreferenceUtils.getString(ACCOUNT_INFO, "");
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.coupon_detail, container, false);
		mBack = view.findViewById(R.id.back);
		mMemberInfo = view.findViewById(R.id.member_info);
		mPick_mode = view.findViewById(R.id.pick_mode);
		mImage = view.findViewById(R.id.image);
		mName = view.findViewById(R.id.name);
		mCoins = view.findViewById(R.id.coins_num);
		mStatus = view.findViewById(R.id.status);
		mTime = view.findViewById(R.id.time_exchange);
		mStock = view.findViewById(R.id.now_stock);
		mConfirm = view.findViewById(R.id.confirm_exchange);
		initView();
		getCouponDetailData(mId);
		return view;
	}

	private void initView() {
		MainActivity parentActivity = (MainActivity) getActivity();
		parentActivity.setBottomTabVisibility(false);
		mConfirm.setOnClickListener(this);
		mBack.setOnClickListener(this);
	}

	public void setId(String id) {
		mId = id;
		getCouponDetailData(mId);
	}

	CouponDetailBean detailBean;

	private void getCouponDetailData(String id) {
		if (TextUtils.isEmpty(id)) {
			return;
		}
		Call<ResponseBody> call = mCouponDetailService.getCouponDetail(id, mToken);
		call.enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				Gson gson = new Gson();
				try {
					String responseStr = response.body().string();
					Log.d("flysea", "getCouponDetailData responseStr " + responseStr);
					java.lang.reflect.Type type = new TypeToken<CouponDetailBean>() {}.getType();
					detailBean = gson.fromJson(responseStr, type);

					if ( detailBean == null || detailBean.getData() == null) {
						Toast.makeText(getContext(),"数据解析异常", Toast.LENGTH_LONG).show();
						return;
					}

					updateUI(detailBean);

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

	private void updateUI(CouponDetailBean detailBean) {
		mMemberInfo.setText("会员信息：" + detailBean.getData().getMember().getNickname() + "  "
						+ detailBean.getData().getMember().getMobile_phone());
		mPick_mode.setText("领取方式：" +detailBean.getData().getPick_mode());
		Picasso.get().load(detailBean.getData().getNormalize_exchangeable_image()).into(mImage);
		mName.setText(detailBean.getData().getNormalize_exchangeable_name());
		mCoins.setText("有茶币 " + detailBean.getData().getExchange_coin());
		mTime.setText(detailBean.getData().getCreated_at());
		//todo no data yet
		mStock.setText("该奖品当前库存：" + detailBean.getData().getRemaining_quantity());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.back:
				mActivity.changePager(PAGER_COUPON, null, true);
				break;
			case R.id.confirm_exchange:

				break;
		}
	}
}
