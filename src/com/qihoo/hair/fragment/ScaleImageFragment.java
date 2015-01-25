package com.qihoo.hair.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.mode.Works;
import com.qihoo.hair.view.ScaleImageView;


public class ScaleImageFragment extends Fragment {
    private int pos;

    public static ScaleImageFragment newInsatance(int pos) {
        ScaleImageFragment sf = new ScaleImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pos", pos);
        sf.setArguments(bundle);
        return sf;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ScaleImageView siv = new ScaleImageView(getActivity());
        Works resid = HairDresserManager.getInstance().getWorksResID(1, pos);

        siv.setImageResource(resid.icon);
        return siv;

    }
}
