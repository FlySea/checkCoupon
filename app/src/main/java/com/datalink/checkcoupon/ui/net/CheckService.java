package com.datalink.checkcoupon.ui.net;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CheckService {
	@Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
	@POST("/api/shop-exchanges/consume")
	Call<ResponseBody> postConsume(@Body RequestBody scanNumber, @Header("Authorization") String token);
}
