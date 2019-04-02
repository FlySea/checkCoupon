package com.datalink.checkcoupon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.datalink.checkcoupon.R;

public class LoginFragment extends BaseFragment implements View.OnClickListener {

    EditText mShopNumber,mPassword;
    Button mLogin;

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

    private void initView() {
        mShopNumber.setOnClickListener(this);
        mPassword.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                Toast.makeText(getContext(), "登陆 " + mShopNumber.getText(), Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
