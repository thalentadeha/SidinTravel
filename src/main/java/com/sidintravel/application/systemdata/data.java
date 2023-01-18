package com.sidintravel.application.systemdata;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.sidintravel.application.administration.userdatalogin;

@Service
public class data {
    private ArrayList<dataTiketbus> bis = new ArrayList<dataTiketbus>() {
        {
            add(new dataTiketbus(1, "Pahala Kencana", "Bandung", "Surabaya", "08:00", "200000", 0));
            add(new dataTiketbus(2, "Lorena", "Jakarta", "Malang", "06:00", "300000", 1));
            add(new dataTiketbus(3, "Agramas", "Yogyakarta", "Jakarta", "12:00", "750000", 0));
        }
    };
    private ArrayList<dataTiketpesawat> pesawat = new ArrayList<dataTiketpesawat>() {
        {
            add(new dataTiketpesawat(1, "Lion Air", "Jakarta", "Balikpapan", "10:50", "800000", 0, 0, 1));
            add(new dataTiketpesawat(2, "Citilink", "Malang", "Jakarta", "16:30", "1200000", 0, 30, 0));
            add(new dataTiketpesawat(3, "Garuda Indonesia", "Jakarta", "Bali", "13:10", "2000000", 1, 40, 1));

        }
    };
    private ArrayList<dataTiketkereta> kereta = new ArrayList<dataTiketkereta>() {
        {
            add(new dataTiketkereta(1, "Kertanegara", "Malang", "Yogyakarta", "08:20", "410000", 1, 1));
            add(new dataTiketkereta(2, "Argo Lawu", "Solo Balapan", "Gambir", "19:00", "600000", 0, 0));
            add(new dataTiketkereta(3, "Argo Wilis", "Bandung", "Surabaya", "22:35", "540000", 0, 1));
        }
    };
    public boolean checkIDpesawat(Integer tempId){
        for(int i=0;i<pesawat.size();i++){
            if(pesawat.get(i).id == tempId){
                return true;
            }
        }
        return false;
    }
    public boolean checkIDkereta(Integer tempId){
        for(int i=0;i<kereta.size();i++){
            if(kereta.get(i).id == tempId){
                return true;
            }
        }
        return false;
    }
    public boolean checkIDbus(Integer tempId){
        for(int i=0;i<bis.size();i++){
            if(bis.get(i).id == tempId){
                return true;
            }
        }
        return false;
    }
    public void addTicket(dataTiketpesawat Temp){
        pesawat.add(Temp);
    }
    public void addTicket(dataTiketkereta Temp){
        kereta.add(Temp);
    }
    public void addTicket(dataTiketbus Temp){
        bis.add(Temp);
    }
    public void removeBus(Integer tempId){
        for(int i=0;i<bis.size();i++){
            if(bis.get(i).id == tempId){
                bis.remove(i);
            }
        }
    }
    public void removeKereta(Integer tempId){
        for(int i=0;i<kereta.size();i++){
            if(kereta.get(i).id == tempId){
                kereta.remove(i);
            }
        }
    }
    public void removePesawat(Integer tempId){
        for(int i=0;i<pesawat.size();i++){
            if(pesawat.get(i).id == tempId){
                pesawat.remove(i);
            }
        }
    }
    public void deletePesawat(dataTiketpesawat Temp){
        pesawat.add(Temp);
    }
    public void deleteKereta(dataTiketkereta Temp){
        kereta.add(Temp);
    }
    public void deleteBus(dataTiketbus Temp){
        bis.add(Temp);
    }
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