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
    protected Boolean isAdmin = false;
    protected String tempEmail;

    // private HashMap<String, String> userpass = new HashMap<>(); // simpen
    // username password
    // private HashMap<String, String> useremail = new HashMap<>(); // simpen
    // username email
    // simpen username, email, password
    private ArrayList<userdatalogin> dataUser = new ArrayList<>() {
        {
            add(new userdatalogin("Rahman", "1234qwerty", "rahman@gmail.com", false));
        }
    };

    public void changeisLogin() {
        this.isLogin = true;
    }

    public void nowisLogout() {
        this.isLogin = false;
        this.isAdmin = false;
    }

    public void changeisNew(String email) {
        for (int i = 0; i < dataUser.size(); i++) {
            if (dataUser.get(i).getEmail().equals(email)) {
                dataUser.get(i).setIsNew(true);
                ;
            }
        }
    }

    public void changeisOld(String email) {
        for (int i = 0; i < dataUser.size(); i++) {
            if (dataUser.get(i).getEmail().equals(email)) {
                dataUser.get(i).setIsNew(false);
            }
        }
    }

    public Boolean checkisNeW() {
        Boolean isNew_result = false;
        for (int i = 0; i < dataUser.size(); i++) {
            if (dataUser.get(i).getEmail().equals(tempEmail)) {
                isNew_result = (Boolean) dataUser.get(i).getIsNew();
            }
        }

        if (isNew_result == true) {
            return true;
        } else {
            return false;
        }
    }

    // check untuk user biasa
    public boolean check(String email, String password) {
        tempEmail = email;
        for (int i = 0; i < dataUser.size(); i++) {
            if (dataUser.get(i).getEmail().equals(email)) {
                if (dataUser.get(i).getPassword().equals(password)) {
                    isLogin = true;
                    return true;
                }
            }
        }

        isLogin = false;
        return false;
    }
        // check untuk user admin
    public boolean check(String password) {
        if (password.equals("123")) {
            return true;
        }
        return false;
    }

    public String getPassword(String email) {
        tempEmail = email;
        for (int i = 0; i < dataUser.size(); i++) {
            if (dataUser.get(i).getEmail().equals(email)) {
                return (String) dataUser.get(i).getPassword();
            }
        }
        return null;
    }

    public boolean getisAdmin() {
        return this.isAdmin;
    }

    public boolean checkisLogin() {
        return isLogin;
    }

    // register
    public boolean register(userdatalogin tempUser) {
        dataUser.add(tempUser);
        return true;
    }

    // check available email
    public boolean checkEmailAvailability(String email) {
        tempEmail = email;
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

    // public void getDiscount() {
    // double tempHarga;
    // for (int i = 0; i < dataUser.size(); i++) {
    // if (dataUser.get(i).getEmail().equals(tempEmail)) {
    // tempHarga = (Double) dataUser
    // }
    // }
    // }

    static <T, V> void giveError(T param1, Model model) {
        model.addAttribute("param1", param1);
    }
}