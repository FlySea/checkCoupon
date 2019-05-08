package com.datalink.checkcoupon.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.activity.MainActivity;
import com.datalink.checkcoupon.ui.model.CheckErrorBean;
import com.datalink.checkcoupon.ui.model.CouponDetailMegeBeanX;
import com.datalink.checkcoupon.ui.net.CheckService;
import com.datalink.checkcoupon.ui.net.CouponDetailService;
import com.datalink.checkcoupon.ui.utils.ErrorMsg;
import com.datalink.checkcoupon.ui.utils.PreferenceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.datalink.checkcoupon.ui.activity.MainActivity.EXTRA_SCAN_NUM;
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
	String mScanNum;

	TextView mName2;
	TextView mStatus2;
	TextView mType2;
	TextView mValid2;
	LinearLayout mQrStyle1;
	LinearLayout mQrStyle2;


	CouponDetailService mCouponDetailService;
	CheckService mCheckService;
	Retrofit mRetrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
			.addConverterFactory(GsonConverterFactory.create()).build();

	Retrofit mCheckRetrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
			.addConverterFactory(GsonConverterFactory.create()).build();

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null ) {
			mScanNum = getArguments().getString(EXTRA_SCAN_NUM);
		}
		mCouponDetailService = mRetrofit.create(CouponDetailService.class);
		mCheckService = mCheckRetrofit.create(CheckService.class);
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
		mName2 = view.findViewById(R.id.name_style2);
		mStatus2 = view.findViewById(R.id.status_style2);
		mType2 = view.findViewById(R.id.type_style2);
		mValid2 = view.findViewById(R.id.valid_time_style2);
		mQrStyle1 = view.findViewById(R.id.qr_style1);
		mQrStyle2 = view.findViewById(R.id.qr_style2);
		initView();
		getCouponDetailData(mScanNum);
		return view;
	}

	private void initView() {
		MainActivity parentActivity = (MainActivity) getActivity();
		parentActivity.setBottomTabVisibility(false);
		mConfirm.setOnClickListener(this);
		mBack.setOnClickListener(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		//getCouponDetailData(mScanNum);
	}

//	public void setId(String id) {
//		mScanNum = id;
//		getCouponDetailData(mScanNum);
//	}

	CouponDetailMegeBeanX detailBean;

	private void getCouponDetailData(String qrStr) {
		if (TextUtils.isEmpty(qrStr)) {
			return;
		}
		Call<ResponseBody> call = mCouponDetailService.getCouponQrDetail(qrStr, mToken);
		call.enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				Gson gson = new Gson();
				try {
					String responseStr = response.body().string();
					Log.d("flysea", "getCouponDetailData responseStr " + responseStr);
					java.lang.reflect.Type type = new TypeToken<CouponDetailMegeBeanX>() {}.getType();
					detailBean = gson.fromJson(responseStr, type);

					if ( detailBean == null || detailBean.getData() == null) {
						if (!TextUtils.isEmpty(ErrorMsg.getErrMsg(responseStr))) {
							//Toast.makeText(getContext(), ErrorMsg.getErrMsg(responseStr), Toast.LENGTH_LONG).show();
							showAlert(ErrorMsg.getErrMsg(responseStr));
						}
						return;
					}

					if (detailBean.getData() != null && detailBean.getData().getCoupon() == null
							&& !TextUtils.isEmpty(detailBean.getData().getPick_mode())) {
						updateUI(detailBean);
					} else if (detailBean.getData().getCoupon() !=null) {
						updateUIStyle2(detailBean);
					} else {
						//Toast.makeText(getContext(),"数据结果异常", Toast.LENGTH_LONG).show();
						showAlert(ErrorMsg.getErrMsg("数据结果异常"));
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

	private void showAlert(String msg) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
		builder.setMessage(msg);
		builder.setCancelable(true);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	private void updateUI(CouponDetailMegeBeanX detailBean) {
		mQrStyle1.setVisibility(View.VISIBLE);
		mQrStyle2.setVisibility(View.GONE);
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

	private void updateUIStyle2(CouponDetailMegeBeanX detailBean) {
		mQrStyle1.setVisibility(View.GONE);
		mQrStyle2.setVisibility(View.VISIBLE);

		 mName2.setText(detailBean.getData().getCoupon().getCoupon().getName());
		 mStatus2.setText(detailBean.getData().getCoupon().getStatus() + "");
		 mType2.setText(detailBean.getData().getCoupon().getCoupon().getCard_type());
		 mValid2.setText(detailBean.getData().getCoupon().getBegin_at() + " ~ " + detailBean.getData().getCoupon().getFinish_at());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.back:
				mActivity.changePager(PAGER_COUPON, null, true);
				break;
			case R.id.confirm_exchange:
				processCheck(mScanNum);
				break;
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
						//Toast.makeText(getContext(),"核销成功",Toast.LENGTH_LONG).show();
						showAlert();

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

	private void showAlert() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder.setTitle("恭喜兑换成功");     //设置对话框标题

		builder.setIcon(android.R.drawable.btn_star);      //设置对话框标题前的图标

		builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {

			@Override

			public void onClick(DialogInterface dialog, int which) {

				//Toast.makeText(getActivity(), "dialog" , Toast.LENGTH_SHORT).show();
				mActivity.changePager(PAGER_COUPON, null, true);

			}

		});

		builder.setCancelable(false);   //设置按钮是否可以按返回键取消,false则不可以取消

		AlertDialog dialog = builder.create();  //创建对话框

		dialog.setCanceledOnTouchOutside(false);      //设置弹出框失去焦点是否隐藏,即点击屏蔽其它地方是否隐藏

		dialog.show();
	}
}
