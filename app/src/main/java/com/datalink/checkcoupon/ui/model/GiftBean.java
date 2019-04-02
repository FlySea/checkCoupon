package com.datalink.checkcoupon.ui.model;

import java.util.List;

public class GiftBean {

	/**
	 * code : 200
	 * data : [{"type":"XXX","id":"1","image":"http://cdn.cblink.net/product/3ff44910c7edea4cc3042af35a2d85fe.png","title":"这是礼品哦哦哦哦","stock":99,"redeemed":44,"consumed":44,"not_consumed":44}]
	 */

	private int code;
	private List<DataBean> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<DataBean> getData() {
		return data;
	}

	public void setData(List<DataBean> data) {
		this.data = data;
	}

	public static class DataBean {
		/**
		 * type : XXX
		 * id : 1
		 * image : http://cdn.cblink.net/product/3ff44910c7edea4cc3042af35a2d85fe.png
		 * title : 这是礼品哦哦哦哦
		 * stock : 99
		 * redeemed : 44
		 * consumed : 44
		 * not_consumed : 44
		 */

		private String type;
		private String id;
		private String image;
		private String title;
		private int stock;
		private int redeemed;
		private int consumed;
		private int not_consumed;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public int getRedeemed() {
			return redeemed;
		}

		public void setRedeemed(int redeemed) {
			this.redeemed = redeemed;
		}

		public int getConsumed() {
			return consumed;
		}

		public void setConsumed(int consumed) {
			this.consumed = consumed;
		}

		public int getNot_consumed() {
			return not_consumed;
		}

		public void setNot_consumed(int not_consumed) {
			this.not_consumed = not_consumed;
		}
	}
}
