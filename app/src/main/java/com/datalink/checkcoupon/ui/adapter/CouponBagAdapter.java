package com.datalink.checkcoupon.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.model.CouponBagBean;
import com.datalink.checkcoupon.ui.viewholder.CouponViewHolder;

import java.util.List;


public class CouponBagAdapter extends RecyclerView.Adapter<CouponViewHolder> {

	private List<CouponBagBean.DataBeanX.DataBean> dataList;
	private Context mContext;
	private LayoutInflater mInflater;
	CouponListener mCouponListener;
	View mView;

	public interface CouponListener {
		public void onItemClick(String id);
	}

	public void setCouponListener (CouponListener listener) {
		mCouponListener = listener;
	}

	public CouponBagAdapter(Context context) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
	}

	public void setDataList(List<CouponBagBean.DataBeanX.DataBean> list) {
		dataList = list;
		notifyDataSetChanged();
	}

	@NonNull
	@Override
	public CouponViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		mView = mInflater.inflate(R.layout.layout_coupon_item, viewGroup, false);
		CouponViewHolder holder = new CouponViewHolder(mView);
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull final CouponViewHolder couponViewHolder, int i) {
		if (dataList == null) {
			return;
		}
		final CouponBagBean.DataBeanX.DataBean dataBean = dataList.get(i);
		if (dataBean != null) {
			couponViewHolder.setType(dataBean.getCoupon_code().getCoupon().getCard_type());
			couponViewHolder.setCardName(dataBean.getCoupon_code().getCoupon().getName());
			if (!TextUtils.isEmpty(dataBean.getCoupon_code().getMember().getName())) {
				couponViewHolder.setMember(dataBean.getCoupon_code().getMember().getName());
			} else {
				couponViewHolder.setMember(dataBean.getCoupon_code().getMember().getNickname() + "");
			}
			couponViewHolder.setPhone(dataBean.getCoupon_code().getMember().getMobile_phone() + "");
			//已核销
			couponViewHolder.setStatus("已核销");
			couponViewHolder.setTime(dataBean.getCoupon_code().getUpdated_at() + "");

			couponViewHolder.root.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//Toast.makeText(mContext, dataBean.getId(), Toast.LENGTH_LONG).show();
//					if (mCouponListener != null) {
//						mCouponListener.onItemClick(String.valueOf(dataBean.getId()));
//					}
				}
			});
		}
	}

	@Override
	public int getItemCount() {
		if (dataList==null) {
			return 0;
		}
		return dataList.size();
	}
}
