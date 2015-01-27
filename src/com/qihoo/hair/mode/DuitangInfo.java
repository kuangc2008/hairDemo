package com.qihoo.hair.mode;

public class DuitangInfo {

	private int height;
	private String albid = "";
	private String msg = "";
	private String isrc = "";
	
	public DuitangInfo(int height, String albid, String msg, String isrc) {
        super();
        this.height = height;
        this.albid = albid;
        this.msg = msg;
        this.isrc = isrc;
    }
	
    public int getWidth(){
		return 200;
	}
	public String getAlbid() {
		return albid;
	}

	public void setAlbid(String albid) {
		this.albid = albid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getIsrc() {
		return isrc;
	}

	public void setIsrc(String isrc) {
		this.isrc = isrc;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
