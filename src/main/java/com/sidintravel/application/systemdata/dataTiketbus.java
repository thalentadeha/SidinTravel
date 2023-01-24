package com.sidintravel.application.systemdata;

public class dataTiketbus extends dataticket {
    private Integer WiFi;

    public dataTiketbus(Integer id, String maskapai, String awal, String tujuan, String jam, String harga,
            Integer WiFi) {
        super(id, maskapai, awal, tujuan, jam, harga);
        this.WiFi = WiFi;
    }

    public Integer getWiFi() {
        return this.WiFi;
    }
}
