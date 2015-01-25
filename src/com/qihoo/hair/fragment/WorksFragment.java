package com.qihoo.hair.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.mode.ShouYi;
import com.qihoo.hair.mode.Works;

import java.util.List;


public class WorksFragment extends Fragment{
    private GridView  mGridView;
    private WorksItemFragment mAdapter = null;
    private List<Works> mWorks = null;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mGridView = (GridView) inflater.inflate(R.layout.fragment_dish_list, null);
        return mGridView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mWorks = HairDresserManager.getInstance().getHDById(1).getmWorks();

        mAdapter = new WorksItemFragment();
        mGridView.setAdapter(mAdapter);
    }

    private class WorksItemFragment extends BaseAdapter {

        @Override
        public int getCount() {
            return mWorks.size();
        }

        @Override
        public Works getItem(int position) {
            return mWorks.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Works work = getItem(position);

            View two = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_dish_list_item, null);
            ImageView icon = (ImageView) two.findViewById(R.id.dish_icon);
            icon.setImageResource( work.icon  );

            TextView name = (TextView) two.findViewById(R.id.dish_name);
            name.setText( work.name );

            TextView two_fav = (TextView) two.findViewById(R.id.dish_fav_num);
            two_fav.setText( work.agree +"");

            ImageButton iv = (ImageButton) two.findViewById(R.id.love_it);
            iv.setImageResource( work.saved ?
                R.drawable.like_click : R.drawable.like);



            icon.setOnClickListener(new MyClick(position));
            two_fav.setOnClickListener(new MyClick(position));
            iv.setOnClickListener(new MyClick(position));
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
                    break;
                case R.id.dish_fav_num:
                    break;
                case R.id.love_it:
                    break;
            }

        }
    }
}
