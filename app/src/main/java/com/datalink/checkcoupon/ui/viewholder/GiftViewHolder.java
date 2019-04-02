package com.datalink.checkcoupon.ui.viewholder;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.utils.ImageTools;

public class GiftViewHolder extends RecyclerView.ViewHolder {

	public void setImage(String url) {
		Bitmap bitmap = ImageTools.getBitMap(url);
		mImage.setImageBitmap(bitmap);
	}

	public void setName(String name) {
		mName.setText(name);
	}

	public void setInventoryNum(int inventoryNum) {
		mInventoryNum.setText(String.valueOf(inventoryNum));
	}

	public void setExchangeNum(int exchangeNum) {
		mExchangeNum.setText(String.valueOf(exchangeNum));
	}

	public void setCheckNum(int checkNum) {
		mCheckNum.setText(String.valueOf(checkNum));
	}

	public void setPendingNum(int pendingNum) {
		mPendingNum.setText(String.valueOf(pendingNum));
	}

	ImageView mImage = itemView.findViewById(R.id.image);
	TextView mName = itemView.findViewById(R.id.name);
	TextView mInventoryNum = itemView.findViewById(R.id.inventory_num);
	TextView mExchangeNum = itemView.findViewById(R.id.exchange_num);
	TextView mCheckNum = itemView.findViewById(R.id.check_num);
	TextView mPendingNum = itemView.findViewById(R.id.pending_num);

	public GiftViewHolder(@NonNull View itemView) {
		super(itemView);
		itemView.setTag(this);
	}


}
