package com.qihoo.hair.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.fragment.ScaleImageFragment;
import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.manager.PhoneMng;
import com.qihoo.hair.mode.MyPhone;
import com.qihoo.hair.mode.Works;

import java.util.List;


public class ScaleImageViewAcitivyt extends FragmentActivity {
    private List<Works> mWorks = null;
    private int pos;
    private MyAdapter myAdapter;
    private ViewPager mViewPager = null;


    public static final String TYPE = "type";
    public static final String TYPE_SAVE = "save";

    private String mType = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);



        pos = getIntent().getIntExtra("pos", 0);
        mType = getIntent().getStringExtra(TYPE);

        myAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myAdapter);
        mViewPager.setCurrentItem(pos);


    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return ScaleImageFragment.newInsatance(i, mType);
        }

        @Override
        public int getCount() {
            if(mType == null) {
                mWorks = HairDresserManager.getInstance().getHDById(1).getmWorks();
                return mWorks.size();
            } else if(mType.equals(TYPE_SAVE)) {
                List<MyPhone> phones = PhoneMng.getInstance().getPhones(100);
                return phones.size();
            }
            return 0;
        }
    }
}
