package com.qihoo.hair.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.mode.HairDresseFactory;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
    }
}
