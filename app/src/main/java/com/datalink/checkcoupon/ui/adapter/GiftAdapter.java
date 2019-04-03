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
import com.datalink.checkcoupon.ui.model.GiftBean;
import com.datalink.checkcoupon.ui.viewholder.CouponViewHolder;
import com.datalink.checkcoupon.ui.viewholder.GiftViewHolder;

import java.util.List;


public class GiftAdapter extends RecyclerView.Adapter<GiftViewHolder> {

	private List<GiftBean.DataBean> dataList;
	private Context mContext;
	private LayoutInflater mInflater;
	GiftListener mGiftListener;
	View mView;

	public interface GiftListener {
		public void onItemClick(String type, String id);
	}

	public void setGiftListener(GiftListener giftListener) {
		mGiftListener = giftListener;
	}

	public GiftAdapter(Context context) {
		mContext = context;
		mInflater = LayoutInflater.from(context);
	}

	public void setDataList(List<GiftBean.DataBean> list) {
		dataList = list;
		notifyDataSetChanged();
	}

	@NonNull
	@Override
	public GiftViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		mView = mInflater.inflate(R.layout.layout_gift_item, viewGroup, false);
		GiftViewHolder holder = new GiftViewHolder(mView);
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull GiftViewHolder giftViewHolder, int i) {
		if (dataList == null) {
			return;
		}
		final GiftBean.DataBean dataBean = dataList.get(i);
		if (dataBean!=null) {
			giftViewHolder.setImage(dataBean.getImage());
			giftViewHolder.setName(dataBean.getTitle());
			giftViewHolder.setInventoryNum(dataBean.getStock());
			giftViewHolder.setExchangeNum(dataBean.getRedeemed());
			giftViewHolder.setCheckNum(dataBean.getConsumed());
			giftViewHolder.setPendingNum(dataBean.getNot_consumed());
		}

		giftViewHolder.mRoot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mGiftListener != null) {
					mGiftListener.onItemClick(dataBean.getType(), dataBean.getId());
				}
			}
		});
	}

	@Override
	public int getItemCount() {
		if (dataList==null) {
			return 0;
		}
		return dataList.size();
	}
}
