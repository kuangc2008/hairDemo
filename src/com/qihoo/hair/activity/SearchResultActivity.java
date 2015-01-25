package com.qihoo.hair.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.common.CommonTitleView;

import java.util.ArrayList;
import java.util.HashMap;


public class SearchResultActivity extends Activity {

    public static String NAME = "name";
    public static String HAS_DOLLAR = "has_dollar";
    public static String HEARTS_NUMBER = "hearts_number";
    public static String GRADE = "grade";
    public static String ADDRESS = "address";
    public static String DISTANCE = "distance";
    public static String PHOTOS_NUMBER = "photos_number";

    //搜索類型：距離
    public final static int SEARCH_TYPE_DISTANCE = 0;
    //搜索類型：人氣
    public final static int SEARCH_TYPE_POPULARITY = 1;
    //搜索類型：作品數
    public final static int SEARCH_TYPE_PHOTOS = 2;
    //搜索類型：評價
    public final static int SEARCH_TYPE_GRADE = 3;
    //搜索類型：優惠活動
    public final static int SEARCH_TYPE_DOLLAR = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_activity);
        setTitleLayout();
        ListView listView = (ListView)findViewById(R.id.search_result_list_view);
        SearchResultAdapter adapter = new SearchResultAdapter(this,getDatabyDistance(),SEARCH_TYPE_DISTANCE);
        listView.setAdapter(adapter);
    }

    private ArrayList<HashMap<String,String>> getDatabyDistance() {
        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String, String>>();
        HashMap<String,String> map;

        map = new HashMap<String, String>();
        map.put(DISTANCE,"0.5km");
        map.put(GRADE,"4.0/5.0(110条评论)");
        map.put(NAME,"理发师A");
        map.put(HAS_DOLLAR,"true");
        map.put(HEARTS_NUMBER,"12");
        map.put(ADDRESS,"朝阳区酒仙桥1号");
        map.put(PHOTOS_NUMBER,"120");
        data.add(map);

        map = new HashMap<String, String>();
        map.put(DISTANCE,"0.5km");
        map.put(GRADE,"4.0/5.0(110条评论)");
        map.put(NAME,"理发师A");
        map.put(HAS_DOLLAR,"true");
        map.put(HEARTS_NUMBER,"12");
        map.put(ADDRESS,"朝阳区酒仙桥1号");
        map.put(PHOTOS_NUMBER,"120");
        data.add(map);

        map = new HashMap<String, String>();
        map.put(DISTANCE,"0.5km");
        map.put(GRADE,"4.0/5.0(110条评论)");
        map.put(NAME,"理发师A");
        map.put(HAS_DOLLAR,"true");
        map.put(HEARTS_NUMBER,"12");
        map.put(ADDRESS,"朝阳区酒仙桥1号");
        map.put(PHOTOS_NUMBER,"120");
        data.add(map);

        map = new HashMap<String, String>();
        map.put(DISTANCE,"0.5km");
        map.put(GRADE,"4.0/5.0(110条评论)");
        map.put(NAME,"理发师A");
        map.put(HAS_DOLLAR,"true");
        map.put(HEARTS_NUMBER,"12");
        map.put(ADDRESS,"朝阳区酒仙桥1号");
        map.put(PHOTOS_NUMBER,"120");
        data.add(map);

        return data;
    }

    private void setTitleLayout() {
        ((TextView)findViewById(R.id.title_layout).findViewById(R.id.title)).setText("搜索结果");
        findViewById(R.id.title_layout).findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}



class SearchResultAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<HashMap<String,String>> arrayList;
    private int searchType;
    public SearchResultAdapter(Context context, ArrayList<HashMap<String,String>> arrayList,int searchType) {
        this.context = context;
        this.arrayList = arrayList;
        this.searchType = searchType;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.search_result_list_item,null);
        TextView name = (TextView)view.findViewById(R.id.name);
        ImageView dollar_sign = (ImageView)view.findViewById(R.id.dollar_sign);
        TextView hearts_number = (TextView)view.findViewById(R.id.hearts_number);
        TextView grade = (TextView)view.findViewById(R.id.grade);
        TextView address = (TextView)view.findViewById(R.id.address);
        TextView distance = (TextView)view.findViewById(R.id.distance);
        TextView photos_number = (TextView)view.findViewById(R.id.photos_number);

        HashMap<String,String> hashMap = arrayList.get(position);
        name.setText(hashMap.get(SearchResultActivity.NAME));
        hearts_number.setText(hashMap.get(SearchResultActivity.HEARTS_NUMBER));
        grade.setText(hashMap.get(SearchResultActivity.GRADE));
        address.setText(hashMap.get(SearchResultActivity.ADDRESS));
        distance.setText(hashMap.get(SearchResultActivity.DISTANCE));
        photos_number.setText(hashMap.get(SearchResultActivity.PHOTOS_NUMBER));
        if (hashMap.get(SearchResultActivity.HAS_DOLLAR).equals("true")) {
            dollar_sign.setVisibility(View.VISIBLE);
        } else {
            dollar_sign.setVisibility(View.INVISIBLE);
        }
        switch (searchType) {
            case SearchResultActivity.SEARCH_TYPE_DISTANCE:
                address.setTextColor(context.getResources().getColor(R.color.red));
                break;
            case SearchResultActivity.SEARCH_TYPE_GRADE:
                grade.setTextColor(context.getResources().getColor(R.color.red));
                break;
            case SearchResultActivity.SEARCH_TYPE_PHOTOS:
                photos_number.setTextColor(context.getResources().getColor(R.color.red));
                break;
            case SearchResultActivity.SEARCH_TYPE_POPULARITY:
                hearts_number.setTextColor(context.getResources().getColor(R.color.red));
                break;
            case SearchResultActivity.SEARCH_TYPE_DOLLAR:
                break;
            default:
                break;
        }
        return view;
    }
}
