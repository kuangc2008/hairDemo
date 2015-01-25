package com.qihoo.hair.mode;


import org.w3c.dom.Comment;

import java.util.List;

public class HairDresser {
    long id;

    private int icon;  //默认icon

    private String iconPath;  //本地存储的icon

    private String iconUrl;  //服务器的iconurl

    private String name;  //名字

    private int sex;  //0标示男， 1表示女

    private String zhiwei;  //店长，高级理发师

    private String mp3Path ;   //音乐地址

    private int backGroundMode;   //页面的模板类型

    private String address;  //地址

    private String activity; //活动

    private List<ShouYi>  mShouYi;

    private List<com.qihoo.hair.mode.Comment> mComments;


    private List<Works> mWorks;

    public List<Works> getmWorks() {
        return mWorks;
    }

    public void setmWorks(List<Works> mWorks) {
        this.mWorks = mWorks;
    }

    public List<com.qihoo.hair.mode.Comment> getmComments() {
        return mComments;
    }

    public void setmComments(List<com.qihoo.hair.mode.Comment> mComments) {
        this.mComments = mComments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HairDresser(int icon, String iconPath, String iconUrl, String name, int sex, String zhiwei, String mp3Path, int backGroundMode, String address, String activity, List<ShouYi> mShouYi) {
        this.icon = icon;
        this.iconPath = iconPath;
        this.iconUrl = iconUrl;
        this.name = name;
        this.sex = sex;
        this.zhiwei = zhiwei;
        this.mp3Path = mp3Path;
        this.backGroundMode = backGroundMode;
        this.address = address;
        this.activity = activity;
        this.mShouYi = mShouYi;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getZhiwei() {
        return zhiwei;
    }

    public void setZhiwei(String zhiwei) {
        this.zhiwei = zhiwei;
    }

    public String getMp3Path() {
        return mp3Path;
    }

    public void setMp3Path(String mp3Path) {
        this.mp3Path = mp3Path;
    }

    public int getBackGroundMode() {
        return backGroundMode;
    }

    public void setBackGroundMode(int backGroundMode) {
        this.backGroundMode = backGroundMode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public List<ShouYi> getmShouYi() {
        return mShouYi;
    }

    public void setmShouYi(List<ShouYi> mShouYi) {
        this.mShouYi = mShouYi;
    }
}
