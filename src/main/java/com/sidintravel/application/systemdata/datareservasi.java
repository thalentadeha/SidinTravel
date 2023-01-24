package com.sidintravel.application.systemdata;

public class datareservasi {
    public String namaPembeli;
    public Integer KTP;
    // protected String jenisKelamin;
    public Integer idTiket;
    public Integer idCode;

    public datareservasi(String namaPembeli, Integer KTP, Integer idTiket, Integer idCode) {
        this.namaPembeli = namaPembeli;
        this.KTP = KTP;
        this.idTiket = idTiket;
        this.idCode = idCode;
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

    public void setidTiket(Integer idTiket) {
        this.idTiket = idTiket;
    }

    public Integer getidTiket() {
        return idTiket;
    }

    public void setidCode(Integer idCode) {
        this.idCode = idCode;
    }

    public Integer getidCode() {
        return idCode;
    }
    // public void setjenisKelamin(String jenisKelamin) {
    // this.jenisKelamin = jenisKelamin;
    // }

    // public String getjenisKelamin() {
    // return jenisKelamin;
    // }

}