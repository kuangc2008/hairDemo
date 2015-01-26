package com.qihoo.hair.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.qihoo.haierdemo.R;
import com.qihoo.hair.adapter.StaggeredAdapter;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorPagerAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorViewPagerAdapter;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
/**
 * Show场.
 */
public class ShowFragment extends BaseFragment {
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    public static final String INTENT_STRING_TABNAME = "intent_String_tabname";
    public static final String INTENT_INT_INDEX = "intent_int_index";
    private String [] tabs = {"热门发型","最新发型","身边发型"};
    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragment_home);
        Resources res = getResources();

        ViewPager viewPager = (ViewPager) findViewById(R.id.fragment_tabmain_viewPager);
        FixedIndicatorView indicator = (FixedIndicatorView) findViewById(R.id.fragment_tabmain_indicator);

        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.RED, 5));
        // indicator.setScrollBar(new ColorBar(getApplicationContext(),
        // Color.RED, 0, Gravity.CENTENT_BACKGROUND));
        // indicator.setScrollBar(new ColorBar(getApplicationContext(),
        // Color.RED, 5, Gravity.TOP));
        // indicator.setScrollBar(new LayoutBar(getApplicationContext(),
        // R.layout.layout_slidebar, Gravity.CENTENT_BACKGROUND));

        float unSelectSize = 16;
        float selectSize = unSelectSize * 1.2f;

        int selectColor = res.getColor(R.color.tab_top_text_2);
        int unSelectColor = res.getColor(R.color.tab_top_text_1);
        indicator.setOnTransitionListener(new OnTransitionTextListener(selectSize, unSelectSize, selectColor, unSelectColor));

        viewPager.setOffscreenPageLimit(4);

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(adapter);
        
        
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    
    
    private IndicatorPagerAdapter adapter = new IndicatorViewPagerAdapter() {

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabs[position]);
            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {
            
            switch(position){
                case 0:
                    if (convertView == null) {
                        convertView = inflate.inflate(R.layout.fragment_tabshow_hottest, container, false);
                    }
                    ViewPager viewPager = (ViewPager)convertView.findViewById(R.id.guide_viewPager);
                    Indicator indicator = (Indicator) convertView.findViewById(R.id.guide_indicator);
                    IndicatorViewPager  indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
                    indicatorViewPager.setAdapter(Banneradapter);
                    PLA_AdapterView  mplaAdapterView = (PLA_AdapterView<ListAdapter>) convertView.findViewById(R.id.list);
                    StaggeredAdapter mAdapter =  initShowAdapter(1);
                    mplaAdapterView.setAdapter(mAdapter);
                    break;
                case 1:
                    if (convertView == null) {
                        convertView = inflate.inflate(R.layout.fragment_tabshow_hottest, container, false);
                    }
                    ViewPager viewPager1 = (ViewPager)convertView.findViewById(R.id.guide_viewPager);
                    Indicator indicator1 = (Indicator) convertView.findViewById(R.id.guide_indicator);
                    IndicatorViewPager  indicatorViewPager1 = new IndicatorViewPager(indicator1, viewPager1);
                    indicatorViewPager1.setAdapter(Banneradapter);
                    PLA_AdapterView  mplaAdapterView1 = (PLA_AdapterView<ListAdapter>) convertView.findViewById(R.id.list);
                    StaggeredAdapter mAdapter1 =  initShowAdapter(2);
                    mplaAdapterView1.setAdapter(mAdapter1);
                    break;
                case 2:
                    if (convertView == null) {
                        convertView = inflate.inflate(R.layout.fragment_tabshow_hottest, container, false);
                    }
                    ViewPager viewPager2 = (ViewPager)convertView.findViewById(R.id.guide_viewPager);
                    Indicator indicator2 = (Indicator) convertView.findViewById(R.id.guide_indicator);
                    IndicatorViewPager  indicatorViewPager2 = new IndicatorViewPager(indicator2, viewPager2);
                    indicatorViewPager2.setAdapter(Banneradapter);
                    PLA_AdapterView  mplaAdapterView2 = (PLA_AdapterView<ListAdapter>) convertView.findViewById(R.id.list);
                    StaggeredAdapter mAdapter2 =  initShowAdapter(3);
                    mplaAdapterView2.setAdapter(mAdapter2);
                    break;
            }
            
            return convertView;
        }

        @Override
        public int getCount() {
            return tabs.length;
        }
    };
    
    public void getFirstView(int position, View convertView, ViewGroup container){
        
    }
    private class MySimpleAdapter extends ArrayAdapter<String> {

        public MySimpleAdapter(Context context, int layoutRes) {
            super(context, layoutRes, android.R.id.text1);
        }
    }
    private Random mRand = new Random();
    
    public StaggeredAdapter  initShowAdapter(int type){
        StaggeredAdapter mStaggeredAdapter = new StaggeredAdapter(getActivity(),type);
        return mStaggeredAdapter;
    }
    
    
    public MySimpleAdapter initSimpleAdapter() {
        MySimpleAdapter   mAdapter = new MySimpleAdapter(getActivity(), R.layout.sample_item);

        for( int i = 0; i < 30; ++i){
            //generate 30 random items.

            StringBuilder builder = new StringBuilder();
            builder.append("Hello!![");
            builder.append(i);
            builder.append("] ");

            char[] chars = new char[mRand.nextInt(500)];
            Arrays.fill(chars, '1');
            builder.append(chars);
            mAdapter.add(builder.toString());
        }
        return mAdapter;
    }
    
    private IndicatorPagerAdapter Banneradapter = new IndicatorViewPagerAdapter() {
        private int[] images = { R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4 };

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_guide, container, false);
            }
            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = new View(getApplicationContext());
                convertView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            }
            convertView.setBackgroundResource(images[position]);
            return convertView;
        }

        @Override
        public int getCount() {
            return images.length;
        }
    };
    
}
