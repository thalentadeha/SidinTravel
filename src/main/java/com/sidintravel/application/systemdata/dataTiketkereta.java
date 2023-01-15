package com.sidintravel.application.systemdata;

public class dataTiketkereta extends dataticket {
    Integer WiFi;
    private Integer Meal;
    public dataTiketkereta(String maskapai, String awal, String tujuan, String jam, double harga,Integer WiFi,Integer Meal) {
        super(maskapai, awal, tujuan, jam, harga);
        this.WiFi = WiFi;
        this.Meal = Meal;
    }
    public Integer getWiFi() {
        return this.WiFi;
    }
    public Integer getMeal() {
        return this.Meal;
    }
}