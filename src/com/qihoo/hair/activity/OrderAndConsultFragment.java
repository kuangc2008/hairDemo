package com.qihoo.hair.activity;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.adapter.AppointmentAdapter;

import android.os.Bundle;
import android.widget.ListView;

/**
 * 预约和咨询服务.
 */
public class OrderAndConsultFragment extends BaseFragment {

    public OrderAndConsultFragment(){}

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragment_appointment);
        ListView mlistview = (ListView) findViewById(R.id.orderlist);
        AppointmentAdapter mAdapter = getAdapter();
        mlistview.setAdapter(mAdapter);
        }
    //准备数据
    public AppointmentAdapter getAdapter(){
        AppointmentAdapter mAdapter = new AppointmentAdapter(getActivity(),1);
        return mAdapter;
    }
}
