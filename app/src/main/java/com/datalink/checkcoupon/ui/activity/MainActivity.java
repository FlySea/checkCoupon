package com.datalink.checkcoupon.ui.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.fragment.CouponFragment;
import com.datalink.checkcoupon.ui.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout mCardBottomTab, mGiftBottomTab;
    FrameLayout mBottomContain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, new CouponFragment());
        transaction.commitNow();
    }



    private void initView(){
        mBottomContain = findViewById(R.id.bottom_container);
        mCardBottomTab = findViewById(R.id.bottom_card);
        mGiftBottomTab = findViewById(R.id.bottom_gift);
    }

    @Override
    public void onClick(View v) {

    }
}
