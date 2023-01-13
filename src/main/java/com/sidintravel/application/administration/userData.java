package com.sidintravel.application.administration;

import java.util.HashMap;

import com.sidintravel.application.administration.*;

import java.util.ArrayList;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;

@Service
public class userData {
    protected String username;
    protected String email;
    protected String password;
    protected Boolean isLogin = false;

    // private HashMap<String, String> userpass = new HashMap<>(); // simpen
    // username password
    // private HashMap<String, String> useremail = new HashMap<>(); // simpen
    // username email

    // simpen username, email, password
    private ArrayList<userdatalogin> dataUser = new ArrayList<>() {
        {
            add(new userdatalogin("Rahman", "1234qwerty", "rahman@gmail.com"));
        }
    };

    // check untuk user biasa
    public boolean check(String email, String password) {
        for (int i = 0; i < dataUser.size(); i++) {
            if (dataUser.get(i).getEmail().equals(email)) {
                if (dataUser.get(i).getPassword().equals(password)) {
                    isLogin = true;
                    return true;
                }
            }
        }
        return false;
    }

    // check untuk user admin
    public boolean check(String email) {
        if (email.equals("123")) {
            return true;
        }
        return false;
    }

    // register
    public boolean register(String username, String email, String password) {
        if (!checkEmailAvailability(email)) {
            System.out.println("Email sudah terpakai atau format salah");
        } else if (!checkUserAvailability(username)) {
            System.out.println("Username sudah terpakai");
        } else {
            userdatalogin temp = new userdatalogin(username, password, email);
            dataUser.add(temp);
            System.out.println(dataUser.size());
            System.out.println("data ditambah ");
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

    static <T, V> void giveError(T param1, Model model) {
        model.addAttribute("param1", param1);
    }
}