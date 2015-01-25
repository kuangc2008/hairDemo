package com.qihoo.hair.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.qihoo.haierdemo.R;
/**
 * 探索发现.
 */
public class SearchAndExploreFragment extends Fragment {

    public SearchAndExploreFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search_explore, container, false);
        View marker1 = (rootView.findViewById(R.id.marker1));
        marker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity(),R.style.customDialog);
                dialog.setContentView(R.layout.map_item);
                dialog.show();
                Window dialogWindow = dialog.getWindow();
//                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                dialogWindow.setBackgroundDrawable(getResources().getDrawable(R.color.offwhite));
//                dialogWindow.setLayout(400,400);
                dialogWindow.setGravity(Gravity.BOTTOM);
//                dialogWindow.

            }
        });
        return rootView;
    }


}
