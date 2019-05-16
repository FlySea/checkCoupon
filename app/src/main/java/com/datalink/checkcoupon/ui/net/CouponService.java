package com.datalink.checkcoupon.ui.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface CouponService {
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @GET("/api/shop-exchanges")
    Call<ResponseBody> getCoupon(@Query("status") String status, @Query("page") String pageCount, @Header("Authorization") String token);

    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    //@GET("/api/shop-exchanges/code-used-list")
    @GET("/api/shop-exchanges/coupon/code-used")
    Call<ResponseBody> getCouponBag(@Header("Authorization") String token);

}
