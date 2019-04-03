package com.datalink.checkcoupon.ui.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GiftDetailService {
	@Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
	@GET("/api/shop-exchange-detail")
	Call<ResponseBody> getCouponDetail(@Query("type") String type, @Query("id") String id, @Header("Authorization") String token);
}
