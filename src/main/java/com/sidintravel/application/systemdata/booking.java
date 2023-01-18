package com.sidintravel.application.systemdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class booking {
    private ArrayList<datareservasi> reservasi = new ArrayList<>();

    public Boolean addBooking(datareservasi temp) {
        reservasi.add(temp);
        return true;
    }

    public List<datareservasi> showBooking() {
        return reservasi;
    }

    public Integer getSize() {
        return reservasi.size();
    }
}
