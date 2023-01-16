package com.sidintravel.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sidintravel.application.administration.*;
import com.sidintravel.application.systemdata.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class SidinTravelController {

    @Autowired
    private data dataTiket;
    @Autowired
    private userData dataUser;
    @Autowired
    private booking bookData;

    @GetMapping
    public String land(Model model) {
        return "landing";
    }

    @GetMapping("/login")
    public String logs(Model model) {
        model.addAttribute("userdatalogin", new userdatalogin("", "", ""));
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "login";
        }

        return "redirect:/home";
    }

    @PostMapping("/login")
    public String logPost(userdatalogin currUser, Model model) {
        model.addAttribute("currUser", currUser);
        String tempEmail = (String) currUser.getEmail();
        String tempPassword = (String) currUser.getPassword();
        Boolean loginResult = dataUser.check(tempEmail, tempPassword);
        if (!loginResult) {
            model.addAttribute("Error", "Salah memasukkan email atau password");
            return "login";
        }

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String hms(Model model) {
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "error";
        }

        return "home";
    }

    @GetMapping("/about_us")
    public String abt(Model model) {
        return "about_us";
    }

    @GetMapping("/register")
    public String reg(Model model) {
        model.addAttribute("userdatalogin", new userdatalogin("", "", ""));
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "register";
        }

        return "home";
    }

    @PostMapping("/register")
    public String regPost(userdatalogin currUser, Model model) {
        model.addAttribute("currUser", currUser);
        String tempUsername = (String) currUser.getUsername();
        String tempEmail = (String) currUser.getEmail();
        Boolean checkUsername = dataUser.checkUserAvailability(tempUsername);
        Boolean checkEmail = dataUser.checkEmailAvailability(tempEmail);
        if (!checkEmail || !checkUsername) {
            model.addAttribute("Error", "Email atau Username sudah dipakai");
            return "register";
        }
        dataUser.register(currUser);
        dataUser.changeisLogin();
        return "redirect:/home";
    }

    @GetMapping("/lupa_pass")
    public String lupapass(Model model) {
        model.addAttribute("userdatalogin", new userdatalogin("", "", ""));
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "lupa_pass";
        }

        return "home";
    }

    @PostMapping("/lupa_pass")
    public String lupapassReg(userdatalogin currUser, Model model) {
        model.addAttribute("currUser", currUser);
        String tempEmail = (String) currUser.getEmail();
        Boolean checkEmail = dataUser.checkEmailAvailability(tempEmail);
        if (!checkEmail) {
            model.addAttribute("password", dataUser.getPassword(tempEmail));
            return "lupa_pass";
        }

        model.addAttribute("Error", "Email tidak ditemukan");
        return "lupa_pass";
    }

    @GetMapping("viewticket/{param}")
    public String ticketView(@PathVariable("param") String param, Model model) {
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "error";
        }

        if (param.equals("Bus")) {
            model.addAttribute("tickets", dataTiket.showBis());
            model.addAttribute("code", '2');
        } else if (param.equals("Kereta")) {
            model.addAttribute("tickets", dataTiket.showKereta());
            model.addAttribute("code", '1');
        } else if (param.equals("Pesawat")) {
            model.addAttribute("tickets", dataTiket.showPesawat());
            model.addAttribute("code", '0');
        }
        return "ticketview";
    }

    @GetMapping("/buyticket")
    public String buyTicketget(datareservasi dataBook, Model model) {
        model.addAttribute("newBuy", new datareservasi("", 0, ""));
        return "custBook";
    }

    @PostMapping("/buyticket")
    public String buyTicketpost(datareservasi dataBook,
            Model model) {
        return "custBook";
    }

    @GetMapping("/Sidinerror")
    public String siderror(Model model) {
        return "error";
    }

    @GetMapping("/Admin")
    public String adminSidin(Model model) {
        model.addAttribute("userdatalogin", new userdatalogin("", "", ""));
        return "adminLogin";
    }

    @PostMapping("/Admin")
    public String adminSidinpost(userdatalogin currAdmin, Model model) {
        String tempPassword = (String) currAdmin.getPassword();
        if (!dataUser.check(tempPassword)) {
            model.addAttribute("Error", "Anda bukan admin ya");
            return "adminLogin";
        }
        return "redirect:/Admin/Add";
    }

    @GetMapping("/Admin/Update")
    public String adminSidinUpdatemenu(Model model) {
        return "adminAddmenu";
    }
    @GetMapping("/Admin/realUpdate/{param}")
    public String adminSidinUpdatespecific(@PathVariable("param") String param, Model model) {
        if (param.equals("Bus")) {
            model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", 0, 0));
            model.addAttribute("code", '2');
        } else if (param.equals("Kereta")) {
            model.addAttribute("newData", new dataTiketkereta(0, "", "", "", "", 0, 0, 0));
            model.addAttribute("code", '1');
        } else if (param.equals("Pesawat")) {
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", 0, 0, 0, 0));
            model.addAttribute("code", '0');
        }
        return "addTicket";
    }
    @PostMapping("/Admin/realUpdate/postPesawat")
    public String adminSidinUpdatespecificPostpesawat(dataTiketpesawat newData, Model model) {
        dataTiket.addPesawat(newData);
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket pesawatnya");
        return "redirect:/Admin/Add";
    }
    @PostMapping("/Admin/realUpdate/postKereta")
    public String adminSidinUpdatespecificPostkereta(dataTiketkereta newData,Model model) {
        dataTiket.addKereta(newData);
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket keretanya");
        return "redirect:/Admin/Add";
    }
    @PostMapping("/Admin/realUpdate/postBus")
    public String adminSidinUpdatespecificPostbus(dataTiketbus newData, Model model) {
        dataTiket.addBus(newData);
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket Busnya");
        return "redirect:/Admin/Add";
    }
    @GetMapping("/Admin/Add")
    public String adminSidinAddmenu(Model model) {
        return "adminAddmenu";
    }

    @GetMapping("/Admin/realAdd/{param}")
    public String adminSidinAddspecific(@PathVariable("param") String param, Model model) {
        if (param.equals("Bus")) {
            model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", 0, 0));
            model.addAttribute("code", '2');
        } else if (param.equals("Kereta")) {
            model.addAttribute("newData", new dataTiketkereta(0, "", "", "", "", 0, 0, 0));
            model.addAttribute("code", '1');
        } else if (param.equals("Pesawat")) {
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", 0, 0, 0, 0));
            model.addAttribute("code", '0');
        }
        return "addTicket";
    }

    @PostMapping("/Admin/realAdd/postPesawat")
    public String adminSidinAddspecificPostpesawat(dataTiketpesawat newData, Model model) {
        dataTiket.addPesawat(newData);
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket pesawatnya");
        return "redirect:/Admin/Add";
    }
    @PostMapping("/Admin/realAdd/postKereta")
    public String adminSidinAddspecificPostkereta(dataTiketkereta newData,Model model) {
        dataTiket.addKereta(newData);
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket keretanya");
        return "redirect:/Admin/Add";
    }
    @PostMapping("/Admin/realAdd/postBus")
    public String adminSidinAddspecificPostbus(dataTiketbus newData, Model model) {
        dataTiket.addBus(newData);
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket Busnya");
        return "redirect:/Admin/Add";
    }
    @GetMapping("/logout")
    public String Logout(Model model){
        dataUser.nowisLogout();
        return "redirect:/";
    }
}