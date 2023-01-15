package com.sidintravel.application.systemdata;

import java.util.*;

public class ticket {
    ArrayList<dataticket> bis = new ArrayList<dataticket>();
    ArrayList<dataticket> pesawat = new ArrayList<dataticket>();
    ArrayList<dataticket> kereta = new ArrayList<dataticket>();

    public void fillData() {
        bis.add(new dataticket("Pahala Kencana", "Bandung", "Surabaya", "tba", 200000));
        bis.add(new dataticket("Lorena", "Jakarta", "Malang", "tba", 300000));
        bis.add(new dataticket("Agramas", "Yogyakarta", "Jakarta", "tba", 750000));

        pesawat.add(new dataticket("Lion Air", "Jakarta", "Balikpapan", "tba", 800000));
        pesawat.add(new dataticket("Citilink", "Malang", "Jakarta", "tba", 1200000));
        pesawat.add(new dataticket("Garuda Indonesia", "Jakarta", "Bali", "tba", 2000000));

        kereta.add(new dataticket("Kertanegara", "Malang", "Yogyakarta", "tba", 410000));
        kereta.add(new dataticket("Argo Lawu", "Solo Balapan", "Gambir", "tba", 600000));
        kereta.add(new dataticket("Argo Wilis", "Bandung", "Surabaya", "tba", 540000));
    }

    // bis
    public void addDataTicket_bis() {

    }

    public void getdataticke_bis() {
        for (int i = 0; i < bis.size(); i++) {
            System.out.println(bis.get(i).maskapai);
            System.out.println(bis.get(i).awal);
            System.out.println(bis.get(i).tujuan);
            System.out.println(bis.get(i).tanggal);
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
            System.out.println(pesawat.get(i).tanggal);
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
            System.out.println(kereta.get(i).tanggal);
            System.out.println(kereta.get(i).harga);
        }
    }
}
