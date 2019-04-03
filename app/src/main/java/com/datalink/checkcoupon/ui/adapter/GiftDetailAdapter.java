package com.datalink.checkcoupon.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.model.GiftDetailBean;
import com.datalink.checkcoupon.ui.viewholder.GiftDetailViewHolder;

import java.util.List;


public class GiftDetailAdapter extends RecyclerView.Adapter<GiftDetailViewHolder> {

	private List<GiftDetailBean.DataBean> dataList;
	private Context mContext;
	private LayoutInflater mInflater;
	View mView;

	public GiftDetailAdapter(Context context) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
	}

	public void setDataList(List<GiftDetailBean.DataBean> list) {
		dataList = list;
		notifyDataSetChanged();
	}

	@NonNull
	@Override
	public GiftDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		mView = mInflater.inflate(R.layout.layout_gift_detail_item, viewGroup, false);
		GiftDetailViewHolder holder = new GiftDetailViewHolder(mView);
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull final GiftDetailViewHolder giftDetailViewHolder, int i) {
		if (dataList == null) {
			return;
		}
		final GiftDetailBean.DataBean dataBean = dataList.get(i);
		if (dataBean!=null) {
			giftDetailViewHolder.mRow.setText(dataBean.getId());
			giftDetailViewHolder.mCreateTime.setText(dataBean.getCreated_at());
			giftDetailViewHolder.mMemberName.setText(dataBean.getMember().getNickname());
			giftDetailViewHolder.mPhone.setText(dataBean.getMember().getMobile_phone());
			giftDetailViewHolder.mStatus.setText(dataBean.getDisplay_status());
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
