package com.datalink.checkcoupon.ui.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CouponDetailService {
	@Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
	@GET(" /api/shop-exchanges/{id}")
	Call<ResponseBody> getCouponDetail(@Path("id") String id, @Header("Authorization") String token);

	@Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
	@GET(" /api/shop-exchange-detail")
	Call<ResponseBody> getCouponQrDetail(@Query("qr_code") String qrCode, @Header("Authorization") String token);

}
