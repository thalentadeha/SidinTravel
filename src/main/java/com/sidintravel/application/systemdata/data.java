package com.sidintravel.application.systemdata;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.sidintravel.application.administration.userdatalogin;

@Service
public class data {
    private ArrayList<dataTiketbus> bis = new ArrayList<dataTiketbus>() {
        {
            add(new dataTiketbus(1, "Pahala Kencana", "Bandung", "Surabaya", "08:00", 200000, 0));
            add(new dataTiketbus(2, "Lorena", "Jakarta", "Malang", "06:00", 300000, 1));
            add(new dataTiketbus(3, "Agramas", "Yogyakarta", "Jakarta", "12:00", 750000, 0));
        }
    };
    private ArrayList<dataTiketpesawat> pesawat = new ArrayList<dataTiketpesawat>() {
        {
            add(new dataTiketpesawat(1, "Lion Air", "Jakarta", "Balikpapan", "10:50", 800000, 0, 0, 1));
            add(new dataTiketpesawat(2, "Citilink", "Malang", "Jakarta", "16:30", 1200000, 0, 30, 0));
            add(new dataTiketpesawat(3, "Garuda Indonesia", "Jakarta", "Bali", "13:10", 2000000, 1, 40, 1));

        }
    };
    private ArrayList<dataTiketkereta> kereta = new ArrayList<dataTiketkereta>() {
        {
            add(new dataTiketkereta(1, "Kertanegara", "Malang", "Yogyakarta", "08:20", 410000, 1, 1));
            add(new dataTiketkereta(2, "Argo Lawu", "Solo Balapan", "Gambir", "19:00", 600000, 0, 0));
            add(new dataTiketkereta(3, "Argo Wilis", "Bandung", "Surabaya", "22:35", 540000, 0, 1));
        }
    };

    public List<dataTiketbus> showBis() {
        return bis;
    }

    public List<dataTiketkereta> showKereta() {
        return kereta;
    }

    public List<dataTiketpesawat> showPesawat() {
        return pesawat;
    }
}