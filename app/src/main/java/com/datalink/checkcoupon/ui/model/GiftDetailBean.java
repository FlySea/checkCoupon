package com.datalink.checkcoupon.ui.model;

import java.util.List;

public class GiftDetailBean {
	/**
	 * code : 200
	 * data : [{"id":1,"consumed_at":"2019-04-01 15:27:42","created_at":"2019-03-27 19:09:10","display_status":"已核销","member":{"nickname":null,"mobile_phone":"18565801192"}}]
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
		 * id : 1
		 * consumed_at : 2019-04-01 15:27:42
		 * created_at : 2019-03-27 19:09:10
		 * display_status : 已核销
		 * member : {"nickname":null,"mobile_phone":"18565801192"}
		 */

		private int id;
		private String consumed_at;
		private String created_at;
		private String display_status;
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

		public MemberBean getMember() {
			return member;
		}

		public void setMember(MemberBean member) {
			this.member = member;
		}

		public static class MemberBean {
			/**
			 * nickname : null
			 * mobile_phone : 18565801192
			 */

			private String nickname;
			private String mobile_phone;

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
