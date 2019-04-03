package com.datalink.checkcoupon.ui.model;

public class CheckErrorBean {
	/**
	 * err_code : 400
	 * msg : 当前产品已于 2019-04-01 15:27:42 核销，请勿重复核销
	 */

	private int err_code;
	private String msg;

	public int getErr_code() {
		return err_code;
	}

	public void setErr_code(int err_code) {
		this.err_code = err_code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
