package com.qihoo.hair.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qihoo.haierdemo.R;

/**
 * Created by dongziyu on 2015/1/25.
 */
public class CommonTitleView extends View{

    private TextView back;
    private TextView title;
    private LinearLayout right_linear;

    public CommonTitleView(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.common_title_layout,null);
        back = (TextView)view.findViewById(R.id.back);
        title = (TextView)view.findViewById(R.id.title);
        right_linear = (LinearLayout)view.findViewById(R.id.right_linear);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setTitle(String titleText) {
        title.setText(titleText);
    }

    public LinearLayout getRightLinear() {
        return right_linear;
    }
}