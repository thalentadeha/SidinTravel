package com.sidintravel.application.systemdata;

import java.text.NumberFormat;
import java.util.Locale;

public class dataticket {
    String maskapai;
    String awal;
    String tujuan;
    String tanggal;
    double harga;

    Locale localeID = new Locale("in", "ID");
    NumberFormat numForm = NumberFormat.getCurrencyInstance(localeID);

    public dataticket(String maskapai, String awal, String tujuan, String tanggal, double harga) {
        this.maskapai = maskapai;
        this.awal = awal;
        this.tujuan = tujuan;
        this.tanggal = tanggal;
        this.harga = harga;
    }

    public String getMaskapai() {
        return maskapai;
    }

    public void setMaskapai(String maskapai) {
        this.maskapai = maskapai;
    }

    public String awal() {
        return awal;
    }

    public void setAwal(String awal) {
        this.awal = awal;
    }

    public String tujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String tanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String harga() {
        return numForm.format(harga);
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    // public String toString() {
    // return maskapai + " " + awal + " " + tujuan + " " + tanggal + " " +
    // numForm.format(harga);
    // }
}
