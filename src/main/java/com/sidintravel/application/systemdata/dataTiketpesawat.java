package com.sidintravel.application.systemdata;

public class dataTiketpesawat extends dataticket {

    private Integer WiFi;
    private Integer Baggage;
    private Integer Meal;
    public dataTiketpesawat(String maskapai, String awal, String tujuan, String tanggal, double harga,Integer WiFi,Integer Baggage,Integer Meal) {
        super(maskapai, awal, tujuan, tanggal, harga);
        this.WiFi = WiFi;
        this.Baggage = Baggage;
        this.Meal = Meal;
    }
    public Integer getWiFi() {
        return this.WiFi;
    }
    public Integer getBaggage() {
        return this.Baggage;
    }
    public Integer getMeal() {
        return this.Meal;
    }
}
