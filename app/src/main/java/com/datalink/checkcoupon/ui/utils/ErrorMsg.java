package com.datalink.checkcoupon.ui.utils;

import android.text.TextUtils;
import android.widget.Toast;

import com.datalink.checkcoupon.ui.model.CheckErrorBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ErrorMsg {

    public static String getErrMsg(String responseStr) {

        String errStr = null;

        Gson gs = new Gson();

        if (responseStr.contains("err_code")) {
            java.lang.reflect.Type type = new TypeToken<CheckErrorBean>() {}.getType();
            CheckErrorBean errorBean = gs.fromJson(responseStr, type);
            if (errorBean !=null && !TextUtils.isEmpty(errorBean.getMsg())) {
                errStr = errorBean.getMsg();
            }

        }

        return errStr;

    }


}
