package com.datalink.checkcoupon.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.activity.MainActivity;
import com.datalink.checkcoupon.ui.model.LoginBean;
import com.datalink.checkcoupon.ui.net.LoginService;
import com.datalink.checkcoupon.ui.utils.PreferenceUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.datalink.checkcoupon.ui.utils.PreferenceUtils.ACCOUNT_INFO;

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    PreferenceUtils mPreferenceUtils;
    EditText mShopNumber,mPassword;
    MainActivity mActivity;
    Button mLogin;

    LoginService mLoginService;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://erp.cblink.net/")
                                .addConverterFactory(GsonConverterFactory.create()).build();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginService = retrofit.create(LoginService.class);
        mPreferenceUtils = new PreferenceUtils(getContext());
        mActivity = ((MainActivity) getActivity());

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("flysea", "Login onresume");
        mShopNumber.setText("");
        mPassword.setText("");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);
        mShopNumber = view.findViewById(R.id.shop_number);
        mPassword = view.findViewById(R.id.password);
        mLogin = view.findViewById(R.id.login);
        initView();
        return view;
    }

    private void postLogin() {
        String username = mShopNumber.getText().toString();
        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(getContext(), "帐号或密码不能为空", Toast.LENGTH_SHORT);
            return;
        }
        final Gson gson = new Gson();
        HashMap<String, String> parasMaps = new HashMap<>();
        parasMaps.put("username" , mShopNumber.getText().toString());
        parasMaps.put("password", mPassword.getText().toString());
        String strEntity = gson.toJson(parasMaps);
        final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), strEntity);
        Call<ResponseBody> call = mLoginService.getToken(requestBody);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Gson gs = new Gson();
                    String token;
                    String responseStr = response.body().string();
                    java.lang.reflect.Type type = new TypeToken<LoginBean>() {}.getType();
                    LoginBean loginBean = gs.fromJson(responseStr,type);

                    if (loginBean ==null || loginBean.getData() == null ) {
                        Toast.makeText(getContext(),"账号或密码不正确", Toast.LENGTH_LONG).show();
                        return;
                    }
                    token = loginBean.getData().getApi_token();
                    if (!TextUtils.isEmpty(token)) {
                        mPreferenceUtils.put(ACCOUNT_INFO, token);
                        Log.d("flysea", "login token is " + token);
                        mActivity.changePager(MainActivity.PAGER_COUPON, null, true);
                    } else {
                        Toast.makeText(getContext(),"账号或密码不正确", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    Toast.makeText(getContext(),"登录异常", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(),"登录异常", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void initView() {
        mShopNumber.setOnClickListener(this);
        mPassword.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        MainActivity parentActivity = (MainActivity) getActivity();
        parentActivity.setBottomTabVisibility(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                postLogin();
                break;

        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.d("flysea", "isVisibleToUser");
                mShopNumber.setText("");
                mPassword.setText("");

        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d("flysea", "onHiddenChanged  hidden = "+hidden);
        mShopNumber.setText("");
        mPassword.setText("");

    }

}
