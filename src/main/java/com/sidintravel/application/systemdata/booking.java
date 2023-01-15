package com.sidintravel.application.systemdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class booking {
    private ArrayList<datareservasi> reservasi = new ArrayList<datareservasi>();

    public void addBooking() {

    }

    public List<datareservasi> getBooking() {
        return reservasi;
    }
}
