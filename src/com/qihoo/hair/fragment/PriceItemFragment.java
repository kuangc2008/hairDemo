package com.qihoo.hair.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.mode.ShouYi;

import java.util.List;

/**
 * Created by chengkuang on 15-1-25.
 */
public class PriceItemFragment extends Fragment {

    private ListView mListView;
    private PriceItemAdatper mAdapter = null;
    private List<ShouYi> mShouYis = null;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mListView = new ListView(getActivity());
        return mListView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mShouYis = HairDresserManager.getInstance().getHDById(1).getmShouYi();

        mAdapter = new PriceItemAdatper();
        mListView.setAdapter(mAdapter);
    }

    private class PriceItemAdatper extends BaseAdapter {

        @Override
        public int getCount() {
            return mShouYis.size();
        }

        @Override
        public ShouYi getItem(int position) {
            return mShouYis.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View two = LayoutInflater.from(getActivity()).inflate(R.layout.simple_two_item, null);
            TextView tv1 = (TextView) two.findViewById(android.R.id.text1);
            TextView tv2 = (TextView) two.findViewById(android.R.id.text2);

            ShouYi shouyin = getItem(position);
            tv1.setText(shouyin.getName());
            tv2.setText(shouyin.getPrieceDesc());
            return two;
        }
    }
}
