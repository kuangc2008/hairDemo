package com.qihoo.hair.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.mode.HairDresseFactory;


public class DetailActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        initActionBar();

    }

    private void initActionBar() {
        View back = findViewById(R.id.actionbar_back);
        back.setBackgroundResource(R.drawable.back_normal);
        back.setOnClickListener(this);
        TextView titleView = (TextView) findViewById(R.id.actionbar_title);
        titleView.setText("资料详情");
        findViewById(R.id.actionbar_item1).setBackgroundResource(R.drawable.like);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.actionbar_back:
                finish();
                break;

        }
    }
}
