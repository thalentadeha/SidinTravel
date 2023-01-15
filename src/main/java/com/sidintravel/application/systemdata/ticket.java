package com.sidintravel.application.systemdata;

import java.util.*;

public class ticket {
    ArrayList<dataticket> bis = new ArrayList<dataticket>();
    ArrayList<dataticket> pesawat = new ArrayList<dataticket>();
    ArrayList<dataticket> kereta = new ArrayList<dataticket>();

    public void fillData() {
        bis.add(new dataticket(1, "Pahala Kencana", "Bandung", "Surabaya", "08:00", 200000));
        bis.add(new dataticket(2, "Lorena", "Jakarta", "Malang", "06:00", 300000));
        bis.add(new dataticket(3, "Agramas", "Yogyakarta", "Jakarta", "12:00", 750000));

        pesawat.add(new dataticket(1, "Lion Air", "Jakarta", "Balikpapan", "10:50", 800000));
        pesawat.add(new dataticket(2, "Citilink", "Malang", "Jakarta", "16:30", 1200000));
        pesawat.add(new dataticket(3, "Garuda Indonesia", "Jakarta", "Bali", "13:10", 2000000));

        kereta.add(new dataticket(1, "Kertanegara", "Malang", "Purwokerto", "08:20", 410000));
        kereta.add(new dataticket(2, "Argo Lawu", "Solo Balapan", "Gambir", "19:00", 600000));
        kereta.add(new dataticket(3, "Argo Wilis", "Bandung", "Surabaya", "22:35", 540000));
    }

    // bis
    public void addDataTicket_bis() {

    }

    public void getdataticket_bis() {
        for (int i = 0; i < bis.size(); i++) {
            System.out.println(bis.get(i).maskapai);
            System.out.println(bis.get(i).awal);
            System.out.println(bis.get(i).tujuan);
            System.out.println(bis.get(i).jam);
            System.out.println(bis.get(i).harga);
        }
    }

    // pesawat
    public void addDataTicket_pesawat() {

    }

    public void getdataticket_pesawat() {
        for (int i = 0; i < pesawat.size(); i++) {
            System.out.println(pesawat.get(i).maskapai);
            System.out.println(pesawat.get(i).awal);
            System.out.println(pesawat.get(i).tujuan);
            System.out.println(pesawat.get(i).jam);
            System.out.println(pesawat.get(i).harga);
        }
    }

    // kereta
    public void addDataTicket_kereta() {

    }

    public void getdataticket_kereta() {
        for (int i = 0; i < kereta.size(); i++) {
            System.out.println(kereta.get(i).maskapai);
            System.out.println(kereta.get(i).awal);
            System.out.println(kereta.get(i).tujuan);
            System.out.println(kereta.get(i).jam);
            System.out.println(kereta.get(i).harga);
        }
    }
}
