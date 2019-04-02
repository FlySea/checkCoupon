package com.datalink.checkcoupon.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.activity.MainActivity;

public class ExchangeDetail extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gift_list, container, false);

        initView();
        return view;
    }

    private void initView() {
        MainActivity parentActivity = (MainActivity) getActivity();
        parentActivity.setBottomTabVisibility(false);
    }
}
