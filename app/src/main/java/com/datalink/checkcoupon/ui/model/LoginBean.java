package com.datalink.checkcoupon.ui.model;

public class LoginBean {
    /**
     * code : 200
     * data : {"api_token":"KabbnYzFuHkJNsaz0ojvfeoNWZZwAt1xHkLqwgW2sJ6gHSQxVFRWx9Lzg4LR6USX"}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * api_token : KabbnYzFuHkJNsaz0ojvfeoNWZZwAt1xHkLqwgW2sJ6gHSQxVFRWx9Lzg4LR6USX
         */

        private String api_token;

        public String getApi_token() {
            return api_token;
        }

        public void setApi_token(String api_token) {
            this.api_token = api_token;
        }
    }
}
