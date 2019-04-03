package com.datalink.checkcoupon.ui.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.datalink.checkcoupon.R;

public class GiftDetailViewHolder extends RecyclerView.ViewHolder {

	public View mRoot = itemView.findViewById(R.id.root);
	public TextView mRow = itemView.findViewById(R.id.row_number);
	public TextView mCreateTime = itemView.findViewById(R.id.create_time);
	public TextView mMemberName = itemView.findViewById(R.id.member_name);
	public TextView mPhone = itemView.findViewById(R.id.phone);
	public TextView mStatus = itemView.findViewById(R.id.status);

	public GiftDetailViewHolder(@NonNull View itemView) {
		super(itemView);
		itemView.setTag(this);
	}


}
