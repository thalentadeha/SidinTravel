package com.sidintravel.application.systemdata;

public class dataTiketkereta extends dataticket {
    private Integer WiFi;
    private Integer Meal;

    public dataTiketkereta(Integer id, String maskapai, String awal, String tujuan, String jam, String harga,
            Integer WiFi, Integer Meal) {
        super(id, maskapai, awal, tujuan, jam, harga);
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