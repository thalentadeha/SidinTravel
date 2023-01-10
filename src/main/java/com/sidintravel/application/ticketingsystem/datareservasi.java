package com.sidintravel.application.ticketingsystem;

public class datareservasi {
    protected String namaPembeli;
    protected int KTP;
    protected String jenisKelamin;

    datareservasi(String namaPembeli, int KTP, String jenisKelamin) {
        this.namaPembeli = namaPembeli;
        this.KTP = KTP;
        this.jenisKelamin = jenisKelamin;
    }

}