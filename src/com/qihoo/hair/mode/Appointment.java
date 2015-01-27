package com.qihoo.hair.mode;

public class Appointment {

	private String Barbername;
	private String BarberLocation ;
	private String BarberImg;
	private String BarberDis;
	
    public Appointment(String barbername, String barberLocation, String barberImg, String barberDis) {
        super();
        Barbername = barbername;
        BarberLocation = barberLocation;
        BarberImg = barberImg;
        BarberDis = barberDis;
    }
    
    public String getBarbername() {
        return Barbername;
    }
    public void setBarbername(String barbername) {
        Barbername = barbername;
    }
    public String getBarberLocation() {
        return BarberLocation;
    }
    public void setBarberLocation(String barberLocation) {
        BarberLocation = barberLocation;
    }
    public String getBarberImg() {
        return BarberImg;
    }
    public void setBarberImg(String barberImg) {
        BarberImg = barberImg;
    }
    public String getBarberDis() {
        return BarberDis;
    }
    public void setBarberDis(String barberDis) {
        BarberDis = barberDis;
    }
	
	

}
