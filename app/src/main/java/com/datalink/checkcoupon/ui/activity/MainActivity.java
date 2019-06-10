package com.datalink.checkcoupon.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.datalink.checkcoupon.R;
import com.datalink.checkcoupon.ui.fragment.CouponBagFragment;
import com.datalink.checkcoupon.ui.fragment.CouponDetailFragment;
import com.datalink.checkcoupon.ui.fragment.CouponFragment;
import com.datalink.checkcoupon.ui.fragment.GiftDetailListFragment;
import com.datalink.checkcoupon.ui.fragment.GiftFragment;
import com.datalink.checkcoupon.ui.fragment.LoginFragment;
import com.datalink.checkcoupon.ui.utils.PreferenceUtils;

import static com.datalink.checkcoupon.ui.utils.PreferenceUtils.ACCOUNT_INFO;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int PAGER_LOGIN = 0;
    public static final int PAGER_COUPON = 1;
    public static final int PAGER_GIFT_LIST = 2;
    public static final int PAGER_GIFT_DETAIL = 3;
    public static final int PAGER_COUPON_DETAIL = 4;
    public static final int PAGER_COUPON_BAG = 5;

    public static final int REQUEST_SCAN_CODE = 100;
    public static final String EXTRA_ID = "extra_id";
    public static final String EXTRA_TYPE = "extra_type";
    public static final String EXTRA_SCAN_NUM = "extra_scan_num";


    LinearLayout mCardBottomTab, mBagBottomTab,  mGiftBottomTab;
    FrameLayout mBottomContain;
    boolean mIsShowBottom = false;

    private int currentPager = PAGER_LOGIN;
    PreferenceUtils mPreferenceUtils;
    String mToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPreferenceUtils = new PreferenceUtils(this);
        mToken = mPreferenceUtils.getString(ACCOUNT_INFO, "");
        if (TextUtils.isEmpty(mToken)) {
            addInitLogin();
        } else {
            changePager(PAGER_COUPON,null, true);
        }
    }

    private void addInitLogin() {
        Fragment fragment = getChangerFragment(PAGER_LOGIN);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragment);
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

    public void changePager(int pagerIndex, Bundle bundle, boolean isShowBottomView) {

        mIsShowBottom = isShowBottomView;

        if (currentPager == pagerIndex) {
            return;
        }

        Fragment fragment = getChangerFragment(pagerIndex);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (bundle != null) {
            Bundle args = new Bundle(bundle);
            fragment.setArguments(args);
        }

        transaction.replace(R.id.fragment_container, fragment);
        currentPager = pagerIndex;

        setBottomTabVisibility(isShowBottomView);

        if (!this.isFinishing()) {
            transaction.commitAllowingStateLoss();
        }
    }

    private Fragment getChangerFragment(int index) {
        switch (index) {
            case PAGER_LOGIN:
                return new LoginFragment();

            case PAGER_COUPON:
                return new CouponFragment();

            case PAGER_GIFT_LIST:
                return new GiftFragment();

            case PAGER_GIFT_DETAIL:
                return new GiftDetailListFragment();

            case PAGER_COUPON_DETAIL:
                return new CouponDetailFragment();

            case PAGER_COUPON_BAG:
                return new CouponBagFragment();

            default:
                return new LoginFragment();
        }
    }


    private void initView(){
        mBottomContain = findViewById(R.id.bottom_container);
        mCardBottomTab = findViewById(R.id.bottom_card);
        mBagBottomTab = findViewById(R.id.bottom_bag);
        mGiftBottomTab = findViewById(R.id.bottom_gift);

        mCardBottomTab.setOnClickListener(this);
        mBagBottomTab.setOnClickListener(this);
        mGiftBottomTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_bag:
                changePager(PAGER_COUPON, null, true);
                break;
            case R.id.bottom_card:
                changePager(PAGER_COUPON_BAG, null, true);
                break;
            case R.id.bottom_gift:
                changePager(PAGER_GIFT_LIST, null, true);
                break;

        }
    }
}
