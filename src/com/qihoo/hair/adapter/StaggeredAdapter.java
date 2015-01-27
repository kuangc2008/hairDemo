package com.qihoo.hair.adapter;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.mode.DuitangInfo;
import java.util.LinkedList;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class StaggeredAdapter extends BaseAdapter {
    private LinkedList<DuitangInfo> mInfos;
    private int type =1;
    private Context context;
    public StaggeredAdapter(Context context,int type) {
        this.context = context;
        mInfos = new LinkedList<DuitangInfo>();
        initInfos(type);
    }
    public void initInfos(int type){
        if(mInfos!=null){
            mInfos.clear();
        }
        switch(type){
            case 1:
                for(int i=0;i<20;i++){
                    int height = 500;
                    if(i==0){
                        height=900;
                    }else if(i%3==1){
                        height=600;
                    }
                    DuitangInfo item = new DuitangInfo(height,"bobo14100709553059"+i+".jpg","叶飞","绝对赞");
                    mInfos.add(item);
                }
                break;
            case 2:
                for(int i=19;i>0;i--){
                    int height = 600;
                    if(i==0){
                        height=800;
                    }else if(i%3==1){
                        height=500;
                    }
                    DuitangInfo item = new DuitangInfo(height,"bobo14100709553059"+i+".jpg","叶飞","绝对赞");
                    mInfos.add(item);
                }
                break;
            case 3:
                for(int i=11;i>0;i--){
                    int height = 500;
                    if(i==0){
                        height=700;
                    }else if(i%5==1){
                        height=900;
                    }
                    DuitangInfo item = new DuitangInfo(height,"bobo14100709553059"+i+".jpg","叶飞","绝对赞");
                    mInfos.add(item);
                }
                break;
            default:
                break;
        }
        
    } 
    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        DuitangInfo duitangInfo = mInfos.get(position);

        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(parent.getContext());
            convertView = layoutInflator.inflate(R.layout.show_list_item, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.news_pic);
            holder.contentView = (TextView) convertView.findViewById(R.id.news_title);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) duitangInfo.getHeight()));
        holder.contentView.setText(duitangInfo.getMsg());
        Drawable mbitmap = (Drawable) context.getResources().getDrawable(R.drawable.bobo141007095530590+position);
        holder.imageView.setBackground(mbitmap);
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView contentView;
        TextView timeView;
    }

    @Override
    public int getCount() {
        return mInfos.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mInfos.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    public void addItemLast(List<DuitangInfo> datas) {
        mInfos.addAll(datas);
    }

    public void addItemTop(List<DuitangInfo> datas) {
        for (DuitangInfo info : datas) {
            mInfos.addFirst(info);
        }
    }
}
