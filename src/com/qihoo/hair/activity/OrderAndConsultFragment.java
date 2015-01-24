package com.qihoo.hair.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qihoo.haierdemo.R;
/**
 * 预约和咨询服务.
 */
public class OrderAndConsultFragment extends Fragment {

    public OrderAndConsultFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        return rootView;
    }
}
