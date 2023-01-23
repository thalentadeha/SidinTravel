package com.sidintravel.application.administration;

import java.util.HashMap;
import java.util.ArrayList;

public class loginsystem {
    protected String username;
    protected String email;
    protected String password;

    // private HashMap<String, String> userpass = new HashMap<>(); // simpen
    // username password
    // private HashMap<String, String> useremail = new HashMap<>(); // simpen
    // username email

    // simpen username, email, password
    private ArrayList<userdatalogin> dataUser = new ArrayList<>();


    // check untuk user biasa
    public boolean check(String email, String password) {
        for (int i = 0; i < dataUser.size(); i++) {
            System.out.println(dataUser.get(i).getEmail());
            if (dataUser.get(i).getEmail().equals(email)) {
                if (dataUser.get(i).getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    // register
    public boolean register(String username, String email, String password, Boolean isNew) {
        if (!checkEmailAvailability(email)) {
            System.out.println("Email sudah terpakai atau format salah");
        } else if (!checkUserAvailability(username)) {
            System.out.println("Username sudah terpakai");
        } else {
            userdatalogin temp = new userdatalogin(username, password, email, isNew);
            dataUser.add(temp);
            System.out.println(dataUser.size());
            System.out.println("data ditambah ");
            return true;
        }
        return false;
    }

    // check untuk user admin
    public boolean check(String username) {
        if (username.equals("123")) {
            return true;
        }
        return false;
    }

    // check available email
    public boolean checkEmailAvailability(String email) {
        if (dataUser.size() == 0) {
            if (email.contains("@")) {
                return true;
            }
            return false;
        } else {
            for (int i = 0; i < dataUser.size(); i++) {
                if (dataUser.get(i).getEmail().equals(email) || !email.contains("@")) {
                    return false;
                }
            }
        }
        return true;
    }

    // check available username
    public boolean checkUserAvailability(String username) {
        if (dataUser.size() == 0) {
            return true;
        } else {
            for (int i = 0; i < dataUser.size(); i++) {
                System.out.println(i);
                if (dataUser.get(i).getUsername().equals(username)) {
                    return false;
                }
            }
        }
        return true;
    }
}