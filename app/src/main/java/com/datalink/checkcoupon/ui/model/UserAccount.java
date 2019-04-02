package com.datalink.checkcoupon.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserAccount implements Parcelable {

    String username;
    String password;

    public UserAccount() {
    }

    protected UserAccount(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<UserAccount> CREATOR = new Creator<UserAccount>() {
        @Override
        public UserAccount createFromParcel(Parcel in) {
            return new UserAccount(in);
        }

        @Override
        public UserAccount[] newArray(int size) {
            return new UserAccount[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }
}
