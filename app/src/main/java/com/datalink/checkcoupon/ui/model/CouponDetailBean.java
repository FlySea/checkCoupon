package com.datalink.checkcoupon.ui.model;

public class CouponDetailBean {

	/**
	 * code : 200
	 * data : {"id":1,"consumed_at":null,"created_at":"2019-03-27 19:09:10","display_status":"待核销","normalize_exchangeable_name":"雨果测试改名","normalize_exchangeable_image":"https://img.yzcdn.cn/upload_files/2018/01/17/Fnvb0VOOx4Zwu8nK7b2byBn6cC60.jpg?imageView2/2/w/600/h/0/q/75/format/jpg","exchange_coin":12,"pick_mode":"到店-丰盛町店","member":{"id":124,"nickname":null,"mobile_phone":"18565801192"}}
	 */

	private int code;
	private DataBean data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public DataBean getData() {
		return data;
	}

	public void setData(DataBean data) {
		this.data = data;
	}

	public static class DataBean {
		/**
		 * id : 1
		 * consumed_at : null
		 * created_at : 2019-03-27 19:09:10
		 * display_status : 待核销
		 * normalize_exchangeable_name : 雨果测试改名
		 * normalize_exchangeable_image : https://img.yzcdn.cn/upload_files/2018/01/17/Fnvb0VOOx4Zwu8nK7b2byBn6cC60.jpg?imageView2/2/w/600/h/0/q/75/format/jpg
		 * exchange_coin : 12
		 * pick_mode : 到店-丰盛町店
		 * member : {"id":124,"nickname":null,"mobile_phone":"18565801192"}
		 */

		private int id;
		private String consumed_at;
		private String created_at;
		private String display_status;
		private String normalize_exchangeable_name;
		private String normalize_exchangeable_image;
		private int exchange_coin;
		private int remaining_quantity;
		private String pick_mode;
		private MemberBean member;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getConsumed_at() {
			return consumed_at;
		}

		public void setConsumed_at(String consumed_at) {
			this.consumed_at = consumed_at;
		}

		public String getCreated_at() {
			return created_at;
		}

		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}

		public String getDisplay_status() {
			return display_status;
		}

		public void setDisplay_status(String display_status) {
			this.display_status = display_status;
		}

		public String getNormalize_exchangeable_name() {
			return normalize_exchangeable_name;
		}

		public void setNormalize_exchangeable_name(String normalize_exchangeable_name) {
			this.normalize_exchangeable_name = normalize_exchangeable_name;
		}

		public String getNormalize_exchangeable_image() {
			return normalize_exchangeable_image;
		}

		public void setNormalize_exchangeable_image(String normalize_exchangeable_image) {
			this.normalize_exchangeable_image = normalize_exchangeable_image;
		}

		public int getExchange_coin() {
			return exchange_coin;
		}

		public void setExchange_coin(int exchange_coin) {
			this.exchange_coin = exchange_coin;
		}

		public int getRemaining_quantity() {
			return remaining_quantity;
		}

		public void setRemaining_quantity(int remaining_quantity) {
			this.remaining_quantity = remaining_quantity;
		}

		public String getPick_mode() {
			return pick_mode;
		}

		public void setPick_mode(String pick_mode) {
			this.pick_mode = pick_mode;
		}

		public MemberBean getMember() {
			return member;
		}

		public void setMember(MemberBean member) {
			this.member = member;
		}

		public static class MemberBean {
			/**
			 * id : 124
			 * nickname : null
			 * mobile_phone : 18565801192
			 */

			private int id;
			private String nickname;
			private String mobile_phone;

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getNickname() {
				return nickname;
			}

			public void setNickname(String nickname) {
				this.nickname = nickname;
			}

			public String getMobile_phone() {
				return mobile_phone;
			}

			public void setMobile_phone(String mobile_phone) {
				this.mobile_phone = mobile_phone;
			}
		}
	}
}
