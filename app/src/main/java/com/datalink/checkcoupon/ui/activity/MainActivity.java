package com.datalink.checkcoupon.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.fragment.CouponFragment;
import com.datalink.checkcoupon.ui.fragment.ExchangeDetail;
import com.datalink.checkcoupon.ui.fragment.GiftFragment;
import com.datalink.checkcoupon.ui.fragment.LoginFragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PAGER_LOGIN = 0;
    public static final int PAGER_COUPON = 1;
    public static final int PAGER_GIFT_LIST = 2;
    public static final int PAGER_EXCHANGE_DETAIL = 3;


    LinearLayout mCardBottomTab, mGiftBottomTab;
    FrameLayout mBottomContain;

    private HashMap<Integer, Fragment> fragments = new HashMap<>();
    private int currentPager = PAGER_LOGIN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
        defaultFragment();
    }

    private void initFragment() {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.fragment_container, new CouponFragment());
//        transaction.commitNow();
        fragments.put(PAGER_LOGIN, new LoginFragment());
        fragments.put(PAGER_COUPON, new CouponFragment());
        fragments.put(PAGER_GIFT_LIST, new GiftFragment());
        fragments.put(PAGER_EXCHANGE_DETAIL, new ExchangeDetail());

    }

    private void defaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragments.get(PAGER_LOGIN));
        currentPager = PAGER_LOGIN;
        transaction.commitNow();
    }

    public void setBottomTabVisibility(boolean isVisible) {
        if (mBottomContain!=null) {
            if (isVisible) {
                mBottomContain.setVisibility(View.VISIBLE);
            } else {
                mBottomContain.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void changePager(int pagerIndex) {
        if (currentPager == pagerIndex) {
            return;
        }

        Fragment fragment = fragments.get(pagerIndex);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (!fragment.isAdded()) {
            transaction.add(R.id.fragment_container, fragment);
        }

        transaction.hide(fragments.get(currentPager));
        transaction.show(fragments.get(pagerIndex));
        currentPager = pagerIndex;

        if (!this.isFinishing()) {
            transaction.commitAllowingStateLoss();
        }

    }



    private void initView(){
        mBottomContain = findViewById(R.id.bottom_container);
        mCardBottomTab = findViewById(R.id.bottom_card);
        mGiftBottomTab = findViewById(R.id.bottom_gift);

        mCardBottomTab.setOnClickListener(this);
        mGiftBottomTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_card:
                changePager(PAGER_COUPON);
                break;
            case R.id.bottom_gift:
                changePager(PAGER_GIFT_LIST);
                break;
        }

    }
}
