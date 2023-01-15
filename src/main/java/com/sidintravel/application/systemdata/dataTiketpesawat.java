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
    @Override
    public String getMaskapai() {
        // TODO Auto-generated method stub
        return super.getMaskapai();
    }
    @Override
    public String getAwal() {
        // TODO Auto-generated method stub
        return super.getAwal();
    }
    @Override
    public Double getHarga() {
        // TODO Auto-generated method stub
        return super.getHarga();
    }
    @Override
    public String getTanggal() {
        // TODO Auto-generated method stub
        return super.getTanggal();
    }
    @Override
    public String getTujuan() {
        // TODO Auto-generated method stub
        return super.getTujuan();
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
