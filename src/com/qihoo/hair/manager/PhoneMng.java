package com.qihoo.hair.manager;


import com.qihoo.haierdemo.R;
import com.qihoo.hair.mode.MyPhone;
import com.qihoo.hair.mode.SavedPhone;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PhoneMng {
    TreeMap<Integer, List<MyPhone>> myPhones = new TreeMap<Integer, List<MyPhone>>();
    TreeMap<Integer, List<SavedPhone>> savePhones = new TreeMap<Integer, List<SavedPhone>>();


    private static PhoneMng instance = new PhoneMng();

    private PhoneMng() {
        List<MyPhone> phones = new ArrayList<MyPhone>();
        MyPhone phone = new MyPhone();
        phone.icon = R.drawable.ic_launcher;
        phone.tag = "今天我换了个新发型，纪念一下";
        phones.add(phone);
        phone = new MyPhone();
        phone.icon = R.drawable.male;
        phone.tag = "下次让理发师还按这个理，哈哈";
        phones.add(phone);
        phone = new MyPhone();
        phone.icon = R.drawable.female;
        phone.tag = "我的头发萌萌哒";
        phones.add(phone);
        phone = new MyPhone();
        phone.icon = android.R.drawable.arrow_down_float;
        phone.tag = "今天的头发好帅啊";
        phones.add(phone);
        phone = new MyPhone();
        phone.icon = android.R.drawable.arrow_down_float;
        phone.tag = "今天的头发好帅啊";
        phones.add(phone);
        myPhones.put(100, phones);


        List<SavedPhone> savedPhones = new ArrayList<SavedPhone>();
        SavedPhone sp = new SavedPhone();
        sp.icon = R.drawable.ic_launcher;
        sp.tag = "锅盖头";
        sp.lifashiIcon = R.drawable.default_user_photo_male;
        sp.name = "金牌理发师";
        savedPhones.add(sp);

        sp.icon = R.drawable.male;
        sp.tag = "自创发型";
        sp.lifashiIcon = R.drawable.default_user_photo_male;
        sp.name = "金手";
        savedPhones.add(sp);

        sp.icon = R.drawable.female;
        sp.tag = "发型有点乱";
        sp.lifashiIcon = R.drawable.default_user_photo_male;
        sp.name = "悠然";
        savedPhones.add(sp);

        sp.icon = R.drawable.img_bg;
        sp.tag = "这个发型";
        sp.lifashiIcon = R.drawable.default_user_photo_male;
        sp.name = "王二";
        savedPhones.add(sp);
        savePhones.put(100, savedPhones);
    }


    public static PhoneMng getInstance() {
        return instance;
    }

    public List<MyPhone> getPhones(int userid) {
        return myPhones.get(userid);
    }

    public List<SavedPhone> getSavePhones(int userid) {
        return savePhones.get(userid);
    }
}
