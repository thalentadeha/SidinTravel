package com.sidintravel.application.systemdata;

public class dataTiketbus extends dataticket {
    Integer WiFi;
    public dataTiketbus(String maskapai, String awal, String tujuan, String jam, double harga,Integer WiFi) {
        super(maskapai, awal, tujuan, jam, harga);
        this.WiFi = WiFi;
    }
    public Integer getWiFi() {
        return this.WiFi;
    }
}
