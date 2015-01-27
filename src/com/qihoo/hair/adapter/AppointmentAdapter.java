package com.qihoo.hair.adapter;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.mode.Appointment;

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


public class AppointmentAdapter extends BaseAdapter {
    private LinkedList<Appointment> mInfos;
    private int type =1;
    private Context context;
    public AppointmentAdapter(Context context,int type) {
        this.context = context;
        mInfos = new LinkedList<Appointment>();
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
                    Appointment item = new Appointment("理发师"+i, "大山子北里"+i+"号", "bobo14100709553059"+i+".jpg", (500+i)+"米");
                    mInfos.add(item);
                }
                break;
            case 2:
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
        Appointment duitangInfo = mInfos.get(position);

        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(parent.getContext());
            convertView = layoutInflator.inflate(R.layout.appointment_list_item, null);
            holder = new ViewHolder();
            holder.imageHeaderView = (ImageView) convertView.findViewById(R.id.item_headerpic);
            holder.DistanceView = (TextView) convertView.findViewById(R.id.barber_distance);
            holder.LocationView = (TextView) convertView.findViewById(R.id.barber_location);
            holder.NameView = (TextView) convertView.findViewById(R.id.barber_name);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        Drawable mbitmap = (Drawable) context.getResources().getDrawable(R.drawable.bobo141007095530590+position);
        holder.imageHeaderView.setBackground(mbitmap);
        holder.DistanceView.setText(duitangInfo.getBarberDis());
        holder.NameView.setText(duitangInfo.getBarbername());
        holder.LocationView.setText(duitangInfo.getBarberLocation());
        return convertView;
    }

    class ViewHolder {
        ImageView imageHeaderView;
        TextView DistanceView;
        TextView LocationView;
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

    public void addItemLast(List<Appointment> datas) {
        mInfos.addAll(datas);
    }

    public void addItemTop(List<Appointment> datas) {
        for (Appointment info : datas) {
            mInfos.addFirst(info);
        }
    }
}
