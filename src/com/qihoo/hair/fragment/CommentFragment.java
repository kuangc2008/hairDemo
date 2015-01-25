package com.qihoo.hair.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.mode.Comment;
import com.qihoo.hair.mode.ShouYi;
import com.qihoo.hair.utils.TimeUtils;

import java.util.List;

/**
 * Created by chengkuang on 15-1-25.
 */
public class CommentFragment extends Fragment{

    private ListView mListView;
    private PriceItemAdatper mAdapter = null;
    private List<Comment> mComments = null;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mListView = new ListView(getActivity());
        return mListView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mComments = HairDresserManager.getInstance().getHDById(1).getmComments();

        mAdapter = new PriceItemAdatper();
        mListView.setAdapter(mAdapter);
    }

    private class PriceItemAdatper extends BaseAdapter {

        @Override
        public int getCount() {
            return mComments.size();
        }

        @Override
        public Comment getItem(int position) {
            return mComments.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View two = LayoutInflater.from(getActivity()).inflate(R.layout.comment_list_adapter_item, null);
            ImageView iv1 = (ImageView) two.findViewById(R.id.user_photo);
            TextView tv1 = (TextView) two.findViewById(R.id.user_name);
            RatingBar bar = (RatingBar) two.findViewById(R.id.user_rate);
            TextView tv2 = (TextView) two.findViewById(R.id.user_rate_tv);
            TextView mComment = (TextView) two.findViewById(R.id.comment);
            TextView mTime = (TextView) two.findViewById(R.id.comment_time);


            Comment comment = getItem(position);

            iv1.setImageResource(comment.icon);
            tv1.setText(comment.name);
            bar.setRating(comment.rank);
            tv2.setText("" + comment.rank  + "分");
            mComment.setText(comment.comment);
            mTime.setText(TimeUtils.getTimeDesc1(comment.time));

            return two;
        }
    }
}
