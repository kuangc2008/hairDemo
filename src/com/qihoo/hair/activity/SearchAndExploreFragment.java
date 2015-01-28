package com.qihoo.hair.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.qihoo.haierdemo.R;

import java.util.ArrayList;

/**
 * 探索发现.
 */
public class SearchAndExploreFragment extends Fragment implements View.OnTouchListener{
    private long firstClick;
    private long lastClick;
    // 计算点击的次数
    private int count;

    private View rootView;
    private View relative1;
    private View relative2;
    private static ListView searchListView;

    public SearchAndExploreFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_search_explore, container, false);
        relative1 = rootView.findViewById(R.id.relative1);
        searchListView = (ListView)rootView.findViewById(R.id.lv);
        initSearchList();

        View marker1 = (relative1.findViewById(R.id.marker11));
        marker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity(),R.style.customDialog);
                dialog.setContentView(R.layout.map_item);
                Window dialogWindow = dialog.getWindow();
                dialogWindow.setGravity(Gravity.BOTTOM);
                dialog.show();
            }
        });

        relative2 = rootView.findViewById(R.id.relative2);
        relative2.setVisibility(View.INVISIBLE);
        searchListView.setVisibility(View.INVISIBLE);

        rootView.setOnTouchListener(this);
        return rootView;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 如果第二次点击 距离第一次点击时间过长 那么将第二次点击看为第一次点击
                if (firstClick != 0 && System.currentTimeMillis() - firstClick > 300) {
                    count = 0;
                }
                count++;
                if (count == 1) {
                    firstClick = System.currentTimeMillis();
                } else if (count == 2) {
                    lastClick = System.currentTimeMillis();
                    // 两次点击小于300ms 也就是连续点击
                    if (lastClick - firstClick < 300) {// 判断是否是执行了双击事件
                        if (relative2.getVisibility()==View.VISIBLE) {
                            relative1.setVisibility(View.VISIBLE);
                            relative2.setVisibility(View.INVISIBLE);
                            rootView.setBackground(getResources().getDrawable(R.drawable.map1));
                        } else {
                            relative1.setVisibility(View.INVISIBLE);
                            relative2.setVisibility(View.VISIBLE);
                            rootView.setBackground(getResources().getDrawable(R.drawable.map2));
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    /**
     * 隐藏搜索提示.
     */
    public static void hideSearchListView() {
        searchListView.setVisibility(View.GONE);
    }

    /**
     * 展示搜索提示.
     */
    public static void showSearchListView() {
        searchListView.setVisibility(View.VISIBLE);
    }

    private void initSearchList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("按距离搜索（从近到远）");
        list.add("按人气搜索（从高到低）");
        list.add("按作品数搜索（从高到低）");
        list.add("按评价搜索（从高到低）");
        list.add("按优惠活动搜索（从近到远）");
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(),R.layout.search_list_item,R.id.search_text,list);
        searchListView.setAdapter(arrayAdapter);
        searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), SearchResultActivity.class));
                        break;

                    default:
                        break;
                }
            }
        });

    }
}
