package com.sidintravel.application.systemdata;

public class datareservasi {
    protected String namaPembeli;
    protected Integer KTP;
    protected String jenisKelamin;

    public datareservasi(String namaPembeli, Integer KTP, String jenisKelamin) {
        this.namaPembeli = namaPembeli;
        this.KTP = KTP;
        this.jenisKelamin = jenisKelamin;
    }

    public void setnamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getnamaPembeli() {
        return namaPembeli;
    }

    public void setKTP(Integer KTP) {
        this.KTP = KTP;
    }

    public Integer getKTP() {
        return KTP;
    }

    public void setjenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getjenisKelamin() {
        return jenisKelamin;
    }

}