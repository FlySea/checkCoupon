package com.datalink.checkcoupon.ui.net;

import com.datalink.checkcoupon.ui.model.UserAccount;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginService {
    @Headers({"Content-Type:application/json;charset=utf-8", "Accept:application/json;"})
    @POST("/api/shop/login")
    Call<ResponseBody> getToken(@Body RequestBody userAccount);
}
