package com.example.sidin.service;

public class dataTiketpesawat extends dataticket {

    String WiFi;
    Integer Baggage;
    public dataTiketpesawat(String maskapai, String awal, String tujuan, String tanggal, double harga,String WiFi,Integer Baggage) {
        super(maskapai, awal, tujuan, tanggal, harga);
        this.WiFi = WiFi;
        this.Baggage = Baggage;
    }
    
}
