package com.datalink.checkcoupon.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.model.CouponBean;
import com.datalink.checkcoupon.ui.viewholder.CouponViewHolder;

import java.util.List;


public class CouponAdapter extends RecyclerView.Adapter<CouponViewHolder> {

	private List<CouponBean.DataBeanX.DataBean> dataList;
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

	public CouponAdapter(Context context) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
	}

	public void setDataList(List<CouponBean.DataBeanX.DataBean> list) {
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
		final CouponBean.DataBeanX.DataBean dataBean = dataList.get(i);
		if (dataBean!=null) {
			couponViewHolder.setType(dataBean.getNormalize_exchangeable_name());
			couponViewHolder.setMember(dataBean.getMember().getNickname());
			couponViewHolder.setPhone(dataBean.getMember().getMobile_phone());
			if (TextUtils.isEmpty(dataBean.getConsumed_at())) {
				couponViewHolder.setStatus("待核销");
				couponViewHolder.setTime("       ");
			} else {
				//已核销
				couponViewHolder.setStatus("已核销");
				couponViewHolder.setTime(dataBean.getConsumed_at());
			}
			couponViewHolder.root.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					//Toast.makeText(mContext, dataBean.getId(), Toast.LENGTH_LONG).show();
					if (mCouponListener != null) {
						mCouponListener.onItemClick(String.valueOf(dataBean.getId()));
					}
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
