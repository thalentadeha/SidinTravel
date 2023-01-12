package com.sidintravel.application.systemdata;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.sidintravel.application.administration.userdatalogin;

@Service
public class data {
    private ArrayList<userdatalogin> dataUser = new ArrayList<>() {
        {
            add(new userdatalogin("Admin Sidin", "Sidinkeren", "sidin@gmail.com"));
        }
    };
    private ArrayList<dataticket> bis = new ArrayList<dataticket>() {
        {
            add(new dataticket("Pahala Kencana", "Bandung", "Surabaya", "tba", "tba", 200000));
            add(new dataticket("Lorena", "Jakarta", "Malang", "tba", "tba", 300000));
            add(new dataticket("Harapan Baru", "Yogyakarta", "Jakarta", "tba", "tba", 150000));
        }
    };
    private ArrayList<dataticket> pesawat = new ArrayList<dataticket>() {
        {
            add(new dataticket("Lion Air", "Jakarta", "Balikpapan", "tba", "tba", 800000));
            add(new dataticket("Citilink", "Malang", "Jakarta", "tba", "tba", 1200000));
            add(new dataticket("Garuda Indonesia", "Jakarta", "Bali", "tba", "tba", 2000000));

        }
    };
    private ArrayList<dataticket> kereta = new ArrayList<dataticket>() {
        {
            add(new dataticket("Kertanegara", "Malang", "Yogyakarta", "tba", "tba", 410000));
            add(new dataticket("Argo Lawu", "Solo Balapan", "Gambir", "tba", "tba", 600000));
            add(new dataticket("Argo Wilis", "Bandung", "Surabaya", "tba", "tba", 540000));
        }
    };

    public List<dataticket> showBis() {
        return bis;
    }

}