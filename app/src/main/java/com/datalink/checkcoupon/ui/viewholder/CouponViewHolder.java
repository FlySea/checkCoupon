package com.datalink.checkcoupon.ui.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.datalink.checkcoupon.R;

public class CouponViewHolder extends RecyclerView.ViewHolder {

	public void setTime(String time) {
		mTime.setText(time);
	}

	public void setType(String type) {
		mType.setText(type);
	}

	public void setMember(String member) {
		mMember.setText(member);
	}

	public void setPhone(String phone) {
		mPhone.setText(phone);
	}

	public void setStatus(String status) {
		mStatus.setText(status);
	}

	TextView mTime = itemView.findViewById(R.id.time);
	TextView mType = itemView.findViewById(R.id.type);
	public TextView mMember = itemView.findViewById(R.id.member);
	TextView mPhone = itemView.findViewById(R.id.phone);
	TextView mStatus = itemView.findViewById(R.id.status);
	public View root = itemView.findViewById(R.id.root);

	public CouponViewHolder(@NonNull View itemView) {
		super(itemView);
		itemView.setTag(this);
	}


}
