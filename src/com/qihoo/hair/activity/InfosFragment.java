package com.qihoo.hair.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.qihoo.haierdemo.R;

/**
 * 潮流资讯.
 */
public class InfosFragment extends BaseFragment {

    public InfosFragment(){}

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragment_fornews);
        WebView mWebview = (WebView) findViewById(R.id.webview);
        
        mWebview.getSettings().setJavaScriptEnabled(true);  

        mWebview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);  

        mWebview.setHorizontalScrollBarEnabled(false);  

        mWebview.getSettings().setSupportZoom(true);  

        mWebview.getSettings().setBuiltInZoomControls(true);  

        mWebview.setInitialScale(70);  

        mWebview.setHorizontalScrollbarOverlay(true); 
        
        mWebview.loadUrl("file:///android_asset/newest.html");
        }
}
