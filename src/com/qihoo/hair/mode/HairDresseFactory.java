package com.qihoo.hair.mode;


import com.qihoo.haierdemo.R;

import java.util.ArrayList;
import java.util.List;

public class HairDresseFactory {

    public static HairDresser createMode1() {
        List<ShouYi> shouyins = new ArrayList<ShouYi>();
        ShouYi sy1 = new ShouYi();
        sy1.setName("剪发");
        sy1.setPrieceDesc("15元（已优惠5元）");

        HairDresser hd = new HairDresser(
                R.drawable.ic_launcher,
                null,
                null,
                "王小二",
                0,
                "店长",
                null,
                0,
                "朝阳区酒仙桥路1号",
                "一周年店庆,一律5折! 最低20元,理一次奖励5元!",
                shouyins
                );
        hd.setId(1);
        return hd;
    }
}
