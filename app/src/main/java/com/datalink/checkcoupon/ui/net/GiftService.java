package com.datalink.checkcoupon.ui.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface GiftService {
	@Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
	@GET("/api/shop-exchange-list")
	Call<ResponseBody> getGiftList(@Header("Authorization") String token);
}
