package com.datalink.checkcoupon.ui.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferenceUtils {

    public static final String ACCOUNT_INFO = "ACCOUNT_INFO";

    private SharedPreferences mSp;

    public PreferenceUtils(Context context) {
        mSp = context.getSharedPreferences(ACCOUNT_INFO, Context.MODE_PRIVATE);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSp.getBoolean(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return mSp.getInt(key, defValue);
    }

    public long getLong(String key, long defValue) {
        return mSp.getLong(key, defValue);
    }

    public float getFloat(String key, float defValue) {
        return mSp.getFloat(key, defValue);
    }

    public String getString(String key, String defValue) {
        return mSp.getString(key, defValue);
    }

    public SharedPreferences getSP(){
        return mSp;
    }

    public void put(String key, Object value) {
        if (value instanceof Boolean) {
            mSp.edit().putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Integer || value instanceof Byte) {
            mSp.edit().putInt(key, (Integer) value).commit();
        } else if (value instanceof Long) {
            mSp.edit().putLong(key, (Long) value).commit();
        } else if (value instanceof Float) {
            mSp.edit().putFloat(key, (Float) value).commit();
        } else if (value instanceof String) {
            mSp.edit().putString(key, (String) value).commit();
        } else if (value == null) {
            mSp.edit().putString(key, "").commit();
        } else {
            mSp.edit().putString(key, value.toString()).commit();
        }
    }

}

