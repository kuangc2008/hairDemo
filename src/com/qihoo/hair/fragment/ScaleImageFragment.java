package com.qihoo.hair.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qihoo.haierdemo.R;
import com.qihoo.hair.activity.ScaleImageViewAcitivyt;
import com.qihoo.hair.manager.HairDresserManager;
import com.qihoo.hair.manager.PhoneMng;
import com.qihoo.hair.mode.MyPhone;
import com.qihoo.hair.mode.Works;
import com.qihoo.hair.view.ScaleImageView;

import java.util.List;


public class ScaleImageFragment extends Fragment {
    private int pos;
    private String type;

    public static ScaleImageFragment newInsatance(int pos, String type) {
        ScaleImageFragment sf = new ScaleImageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("pos", pos);
        bundle.putString("type", type);
        sf.setArguments(bundle);
        return sf;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt("pos");
        type = getArguments().getString(ScaleImageViewAcitivyt.TYPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.scale_image_layout, null);
        ScaleImageView siv = (ScaleImageView) v.findViewById(R.id.image_view);
        TextView tv = (TextView) v.findViewById(R.id.iv);

        int icon = 0;
        String text = "";
        if(type == null) {
            Works resid = HairDresserManager.getInstance().getWorksResID(1, pos);
            icon = resid.icon;
            text = resid.name;
        } else if(type.equals(ScaleImageViewAcitivyt.TYPE_SAVE)) {
            List<MyPhone> phoens =  PhoneMng.getInstance().getPhones(100);
            icon = phoens.get(pos).icon;
            text = phoens.get(pos).tag;
        }

        siv.setImageResource(icon);
        tv.setText(text);
        return v;

    }
}
