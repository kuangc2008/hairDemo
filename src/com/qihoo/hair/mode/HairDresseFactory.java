package com.qihoo.hair.mode;


import com.qihoo.haierdemo.R;
import com.qihoo.hair.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

public class HairDresseFactory {

    public static HairDresser createMode1() {
        List<ShouYi> shouyins = new ArrayList<ShouYi>();
        ShouYi sy1 = new ShouYi();
        sy1.setName("剪发");
        sy1.setPrieceDesc("15元（已优惠5元）");
        shouyins.add(sy1);

        ShouYi sy2 = new ShouYi();
        sy2.setName("水洗");
        sy2.setPrieceDesc("10元");
        shouyins.add(sy2);


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


        List<Comment> mComments = new ArrayList<Comment>();
        Comment comment1 = new Comment();
        comment1.comment = "四星推荐，理发师技术很好，就是爱唠叨，哈哈~";
        comment1.icon = R.drawable.default_user_photo_male;
        comment1.name = "忠实顾客1";
        comment1.rank = 4;
        comment1.time = TimeUtils.pareseTime(2013, 10, 17);
        mComments.add(comment1);

        Comment comment2 = new Comment();
        comment2.comment = "三星，理发师垃圾，不能再多了";
        comment2.icon = R.drawable.default_user_photo_male;
        comment2.name = "傻逼顾客2";
        comment2.rank = 3;
        comment2.time = TimeUtils.pareseTime(2013, 1, 3);
        mComments.add(comment2);

        hd.setmComments(mComments);


        List<Works> nWorks = new ArrayList<Works>();
        Works work1 = new Works();
        work1.agree = 3;
        work1.saved = false;
        work1.name = "神秘一变";
        work1.icon = R.drawable.ic_launcher;
        nWorks.add(work1);

        Works work2 = new Works();
        work2.agree = 4;
        work2.saved = false;
        work2.name = "发特风格";
        work2.icon = R.drawable.ic_launcher;
        nWorks.add(work2);

        Works work3 = new Works();
        work3.agree = 3;
        work3.saved = false;
        work3.name = "神秘一变";
        work3.icon = R.drawable.ic_launcher;
        nWorks.add(work3);

        Works work4 = new Works();
        work4.agree = 3;
        work4.saved = false;
        work4.name = "神秘一变";
        work4.icon = R.drawable.ic_launcher;
        nWorks.add(work4);

        hd.setmWorks(nWorks);


        return hd;
    }
}
