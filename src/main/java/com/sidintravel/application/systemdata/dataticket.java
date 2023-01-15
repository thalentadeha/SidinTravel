package com.sidintravel.application.systemdata;

import java.text.NumberFormat;
import java.util.Locale;

import io.micrometer.observation.transport.Propagator.Getter;

public class dataticket {
    Integer id;
    String maskapai;
    String awal;
    String tujuan;
    String jam;
    double harga;

    Locale localeID = new Locale("in", "ID");
    NumberFormat numForm = NumberFormat.getCurrencyInstance(localeID);

    public dataticket(Integer id, String maskapai, String awal, String tujuan, String jam, double harga) {
        this.id = id;
        this.maskapai = maskapai;
        this.awal = awal;
        this.tujuan = tujuan;
        this.jam = jam;
        this.harga = harga;
    }

    public Integer getID() {
        return id;
    }

    public Integer setID() {
        this.id = id;
    }

    public String getMaskapai() {
        return maskapai;
    }

    public String getAwal() {
        return awal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getJam() {
        return jam;
    }

    public Double getHarga() {
        return harga;
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

    public String jam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
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
