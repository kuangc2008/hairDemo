package com.qihoo.hair.mode;

public class Discount {

	private String discount_endtime;
	private String discount_count ;
	private String discount_img;
	private String discount_barbername;
	private String discount_constant;
    public Discount(String discount_endtime, String discount_count, String discount_img,
            String discount_barbername, String discount_constant) {
        super();
        this.discount_endtime = discount_endtime;
        this.discount_count = discount_count;
        this.discount_img = discount_img;
        this.discount_barbername = discount_barbername;
        this.discount_constant = discount_constant;
    }
    public String getDiscount_endtime() {
        return discount_endtime;
    }
    public void setDiscount_endtime(String discount_endtime) {
        this.discount_endtime = discount_endtime;
    }
    public String getDiscount_count() {
        return discount_count;
    }
    public void setDiscount_count(String discount_count) {
        this.discount_count = discount_count;
    }
    public String getDiscount_img() {
        return discount_img;
    }
    public void setDiscount_img(String discount_img) {
        this.discount_img = discount_img;
    }
    public String getDiscount_barbername() {
        return discount_barbername;
    }
    public void setDiscount_barbername(String discount_barbername) {
        this.discount_barbername = discount_barbername;
    }
    public String getDiscount_constant() {
        return discount_constant;
    }
    public void setDiscount_constant(String discount_constant) {
        this.discount_constant = discount_constant;
    }
	

}
