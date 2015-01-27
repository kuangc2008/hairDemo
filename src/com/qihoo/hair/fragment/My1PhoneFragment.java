package com.qihoo.hair.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.activity.ScaleImageViewAcitivyt;
import com.qihoo.hair.manager.PhoneMng;
import com.qihoo.hair.mode.MyPhone;

import java.util.List;


public class My1PhoneFragment extends Fragment{
    private GridView  mGridView;
    private WorksItemFragment mAdapter = null;
    private List<MyPhone> mSavePhones = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mGridView = (GridView) inflater.inflate(R.layout.fragment_dish_list, null);
        return mGridView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSavePhones = PhoneMng.getInstance().getPhones(100);

        mAdapter = new WorksItemFragment();
        mGridView.setAdapter(mAdapter);
    }

    private class WorksItemFragment extends BaseAdapter {

        @Override
        public int getCount() {
            return mSavePhones.size();
        }

        @Override
        public MyPhone getItem(int position) {
            return mSavePhones.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyPhone phone = getItem(position);

            View two = LayoutInflater.from(getActivity()).inflate(R.layout.saved_phone, null);
            ImageView icon = (ImageView) two.findViewById(R.id.dish_icon);
            icon.setImageResource( phone.icon  );

            TextView name = (TextView) two.findViewById(R.id.dish_name);
            name.setText( phone.tag );
            icon.setOnClickListener(new MyClick(position));
            return two;
        }
    }


    public class MyClick implements View.OnClickListener {
        private int pos;

        public MyClick(int pos) {
            this.pos = pos;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.dish_icon:
                    Intent i = new Intent(getActivity(), ScaleImageViewAcitivyt.class);
                    i.putExtra(ScaleImageViewAcitivyt.TYPE, ScaleImageViewAcitivyt.TYPE_SAVE);
                    i.putExtra("pos", pos);
                    getActivity().startActivity(i);
                    break;
                case R.id.dish_fav_num:
                    break;
                case R.id.love_it:
                    break;
            }

        }
    }
}
