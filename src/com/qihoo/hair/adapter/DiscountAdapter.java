package com.qihoo.hair.adapter;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.mode.Discount;

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
import android.widget.TextView;


public class DiscountAdapter extends BaseAdapter {
    private LinkedList<Discount> mInfos;
    private int type =1;
    private Context context;
    public DiscountAdapter(Context context,int type) {
        this.context = context;
        mInfos = new LinkedList<Discount>();
        initInfos(type);
    }
    public void initInfos(int type){
        if(mInfos!=null){
            mInfos.clear();
        }
        switch(type){
            case 1:
                for(int i=0;i<20;i++){
                    Discount item = new Discount("2015.1."+(1+i), ""+100, "bobo14100709553059"+i+".jpg", "天上人间","提供一切你像不到的服务提供一切你像不到的服务提供一切你像不到的服务");
                    mInfos.add(item);
                }
                break;
            case 2:
                for(int i=0;i<5;i++){
                    Discount item = new Discount("2014.1."+(1+i), ""+100, "bobo14100709553059"+i+".jpg", "天上人间","提供一切你像不到的服务提供一切你像不到的服务提供一切你像不到的服务");
                    mInfos.add(item);
                }
                break;
            case 3:
                break;
            default:
                break;
        }
        
    } 
    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        Discount duitangInfo = mInfos.get(position);

        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(parent.getContext());
            convertView = layoutInflator.inflate(R.layout.discount_list_item, null);
            holder = new ViewHolder();
            holder.imageHeaderView = (ImageView) convertView.findViewById(R.id.item_headerpic);
            holder.ConstantView = (TextView) convertView.findViewById(R.id.discount_contant);
            holder.EndTimeView = (TextView) convertView.findViewById(R.id.discount_endtime);
            holder.NameView = (TextView) convertView.findViewById(R.id.discount_from);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        Drawable mbitmap = (Drawable) context.getResources().getDrawable(R.drawable.bobo141007095530590+position);
        holder.imageHeaderView.setBackground(mbitmap);
        holder.ConstantView.setText(duitangInfo.getDiscount_constant());
        holder.NameView.setText(duitangInfo.getDiscount_barbername());
        holder.EndTimeView.setText(duitangInfo.getDiscount_endtime());
        return convertView;
    }

    class ViewHolder {
        ImageView imageHeaderView;
        TextView EndTimeView;
        TextView ConstantView;
        TextView NameView;
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

    public void addItemLast(List<Discount> datas) {
        mInfos.addAll(datas);
    }

    public void addItemTop(List<Discount> datas) {
        for (Discount info : datas) {
            mInfos.addFirst(info);
        }
    }
}
