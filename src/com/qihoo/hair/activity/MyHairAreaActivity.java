package com.qihoo.hair.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.fragment.My1PhoneFragment;
import com.qihoo.hair.fragment.SavedPhoneFragment;


public class MyHairAreaActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager mViewPager = null;
    private View[] mButtons = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_haier_area);
        initActionBar();

    }

    private void initActionBar() {
        View back = findViewById(R.id.actionbar_back);
        back.setBackgroundResource(R.drawable.back_normal);
        back.setOnClickListener(this);
        TextView titleView = (TextView) findViewById(R.id.actionbar_title);
        titleView.setText("我的发艺空间");
        findViewById(R.id.actionbar_item1).setBackgroundResource(R.drawable.like);


        mButtons = new Button[2];
        mButtons[0] = findViewById(R.id.jiamubiao);
        mButtons[0].setOnClickListener(this);
        mButtons[1] = findViewById(R.id.zuopinji);
        mButtons[1].setOnClickListener(this);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new DetailPagerAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(0);
        mButtons[0].setSelected(true);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                setSelect(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.actionbar_back:
                finish();
                break;
            case R.id.jiamubiao:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.zuopinji:
                mViewPager.setCurrentItem(1);
                break;


        }
    }

    private void setSelect(int pos) {
        for(int i=0; i<mButtons.length; i++) {
            if( i != pos) {
                mButtons[i].setSelected(false);
            } else {
                mButtons[i].setSelected(true);
            }
        }
    }


    private static class DetailPagerAdapter extends FragmentPagerAdapter {

        public DetailPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if(i == 1) {
                return new My1PhoneFragment();
            } else if(i == 0) {
                return new SavedPhoneFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
