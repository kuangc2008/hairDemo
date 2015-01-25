package com.qihoo.hair.manager;


import com.qihoo.hair.mode.HairDresseFactory;
import com.qihoo.hair.mode.HairDresser;
import com.qihoo.hair.mode.Works;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class HairDresserManager {

    private static HairDresserManager mInstance = new HairDresserManager();

    private static TreeMap<Long, HairDresser> mHairDresser = new TreeMap<Long, HairDresser>();
    static {
        HairDresser hd = HairDresseFactory.createMode1();
        mHairDresser.put(hd.getId(), hd);
    }

    public static HairDresserManager getInstance() {
        return mInstance;
    }

    public static Map<Long, HairDresser> getAllHairDresser() {
        return mHairDresser;
    }

    
    
    public HairDresser getHDById(long id) {
        return mHairDresser.get(id);
    }


    public Works getWorksResID(long id, int pos) {
        return mHairDresser.get(id).getmWorks().get(pos);
    }

}
