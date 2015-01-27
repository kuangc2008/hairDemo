package com.qihoo.hair.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.qihoo.haierdemo.R;
import com.qihoo.hair.adapter.DiscountAdapter;
import com.qihoo.hair.adapter.StaggeredAdapter;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorPagerAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorViewPagerAdapter;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.slidebar.LayoutBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar.Gravity;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
/**
 * 优惠券和红包.
 */
public class DiscountFragment extends BaseFragment {

    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    public static final String INTENT_STRING_TABNAME = "intent_String_tabname";
    public static final String INTENT_INT_INDEX = "intent_int_index";
    private String [] tabs = {"当前","历史"};
    public DiscountFragment(){}

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragment_discount);
        
        Resources res = getResources();

        ViewPager viewPager = (ViewPager) findViewById(R.id.fragment_tabmain_viewPager);
        FixedIndicatorView indicator = (FixedIndicatorView) findViewById(R.id.fragment_tabmain_indicator);

//        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.RED, 5));
        // indicator.setScrollBar(new ColorBar(getApplicationContext(),
        // Color.RED, 0, Gravity.CENTENT_BACKGROUND));
        // indicator.setScrollBar(new ColorBar(getApplicationContext(),
        // Color.RED, 5, Gravity.TOP));
         indicator.setScrollBar(new LayoutBar(getApplicationContext(),
         R.layout.layout_slidebar, Gravity.CENTENT_BACKGROUND));

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
                        convertView = inflate.inflate(R.layout.discount_list, container, false);
                    }
                    ListView mlistview = (ListView) convertView.findViewById(R.id.discount_list);
                    DiscountAdapter mAdapter = new DiscountAdapter(getActivity(),1);
                    mlistview.setAdapter(mAdapter);
                    break;
                case 1:
                    if (convertView == null) {
                        convertView = inflate.inflate(R.layout.discount_list, container, false);
                    }
                    ListView mlistview1 = (ListView) convertView.findViewById(R.id.discount_list);
                    DiscountAdapter mAdapter1 = new DiscountAdapter(getActivity(),2);
                    mlistview1.setAdapter(mAdapter1);
                    break;
            }
            
            return convertView;
        }

        @Override
        public int getCount() {
            return tabs.length;
        }
    };
}
