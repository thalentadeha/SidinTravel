package com.example.sidin.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class data {
    private ArrayList<dataTiketbus> bis = new ArrayList<dataTiketbus>(){
        {
            add(new dataTiketbus("Pahala Kencana", "Bandung", "Surabaya", "tba", 200000));
            add(new dataTiketbus("Lorena", "Jakarta", "Malang", "tba", 300000));
            add(new dataTiketbus("Harapan Baru", "Yogyakarta", "Jakarta", "tba", 150000));
        }
    };
    private ArrayList<dataTiketpesawat> pesawat = new ArrayList<dataTiketpesawat>(){
        {
            add(new dataTiketpesawat("Lion Air", "Jakarta", "Balikpapan", "tba", 800000,"Tidak tersedia",30));
            add(new dataTiketpesawat("Citilink", "Malang", "Jakarta", "tba", 1200000,"Tidak tersedia",30));
            add(new dataTiketpesawat("Garuda Indonesia", "Jakarta", "Bali", "tba", 2000000,"Tersedia",40));

        }
    };
    private ArrayList<dataTiketkereta> kereta = new ArrayList<dataTiketkereta>(){
        {
            add(new dataTiketkereta("Kertanegara", "Malang", "Yogyakarta", "tba", 410000));
            add(new dataTiketkereta("Argo Lawu", "Solo Balapan", "Gambir", "tba", 600000));
            add(new dataTiketkereta("Argo Wilis", "Bandung", "Surabaya", "tba", 540000));
        }
    };
    public List<dataTiketbus> showBis(){
        return bis;
    }
    public List<dataTiketkereta> showKereta(){
        return kereta;
    }
    public List<dataTiketpesawat> showPesawat(){
        return pesawat;
    }
    
}
