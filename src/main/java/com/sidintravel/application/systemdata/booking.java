package com.sidintravel.application.systemdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class booking {
    private ArrayList<datareservasi> reservasi = new ArrayList<datareservasi>();

    public void addBooking(datareservasi temp) {
        reservasi.add(temp);
    }

    public List<datareservasi> showBooking() {
        return reservasi;
    }

    public datareservasi showBuyBookingBus(Integer idtemp) {
        int r = 0;
        for (int i = 0; i < reservasi.size(); i++) {
            if (reservasi.get(i).getidTiket() == idtemp && reservasi.get(i).getidCode() == 2) {
                r = i;
            }
        }
        return reservasi.get(r);
    }

    public datareservasi showBuyBookingKereta(Integer idtemp) {
        int r = 0;
        for (int i = 0; i < reservasi.size(); i++) {
            if (reservasi.get(i).getidTiket() == idtemp && reservasi.get(i).getidCode() == 1) {
                r = i;
            }
        }
        return reservasi.get(r);
    }

    public datareservasi showBuyBookingPesawat(Integer idtemp) {
        int r = 0;
        for (int i = 0; i < reservasi.size(); i++) {
            if (reservasi.get(i).getidTiket() == idtemp && reservasi.get(i).getidCode() == 0) {
                r = i;
            }
        }
        return reservasi.get(r);
    }

    public Integer getSize() {
        return reservasi.size();
    }
}
