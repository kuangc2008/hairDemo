package com.qihoo.hair.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ViewSwitcher;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.fragment.ScaleImageFragment;
import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.mode.Works;
import com.qihoo.hair.view.ScaleImageView;

import java.util.List;


public class ScaleImageViewAcitivyt extends FragmentActivity {
    private List<Works> mWorks = null;
    private int pos;
    private MyAdapter myAdapter;
    private ViewPager mViewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);


        mWorks = HairDresserManager.getInstance().getHDById(1).getmWorks();
        pos = getIntent().getIntExtra("pos", 0);
        int drawable  = getIntent().getIntExtra("aa", R.drawable.ic_launcher);

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
            return ScaleImageFragment.newInsatance(i);
        }

        @Override
        public int getCount() {
            return mWorks.size();
        }
    }
}
