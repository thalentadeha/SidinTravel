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
        model.addAttribute("userdatalogin", new userdatalogin("", "", "", false));
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
        dataUser.changeisLogin();
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
        model.addAttribute("userdatalogin", new userdatalogin("", "", "", true));
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
        return "redirect:/reg_success";
    }

    @GetMapping("/reg_success")
    public String regsuccess(userdatalogin currUser, Model model) {
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "reg_success";
        }

        return "home";
    }

    @PostMapping("/reg_success")
    public String regsuccesspost(userdatalogin currUser, Model model) {
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "login";
        }
        return "login";
    }

    @GetMapping("/lupa_pass")
    public String lupapass(Model model) {
        model.addAttribute("userdatalogin", new userdatalogin("", "", "", false));
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
        // Boolean isNew = dataUser.checkisNeW();
        if (!isLogin) {
            return "error";
        }
        // if (isNew == true) {

        // }
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
        model.addAttribute("userdatalogin", new userdatalogin("", "", "", false));
        model.addAttribute("isAdmin", dataUser.getisAdmin());
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
    @GetMapping("/Admin/Delete")
    public String adminSidinDeletemenu(Model model) {
        return "adminDeletemenu";
    }

    @GetMapping("/Admin/realDelete/{param}")
    public String adminSidinDeletespecific(@PathVariable("param") String param, Model model) {
        if (param.equals("Bus")) {
            model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
            model.addAttribute("code", '2');
        } else if (param.equals("Kereta")) {
            model.addAttribute("newData", new dataTiketkereta(0, "", "", "", "", "0", 0, 0));
            model.addAttribute("code", '1');
        } else if (param.equals("Pesawat")) {
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '0');
        }
        return "deleteTicket";
    }

    @PostMapping("/Admin/realDelete/postPesawat")
    public String adminSidinDeletespecificPostpesawat(dataTiketpesawat newData, Model model) {
        if(!dataTiket.checkIDpesawat(newData.getId())){
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '0');
            model.addAttribute("Error", "Id tidak ditemukan");
            return "deleteTicket";
        }
        dataTiket.removePesawat(newData.getId());
        model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
        model.addAttribute("code", '0');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil delete tiket pesawatnya");
        return "deleteTicket";
    }

    @PostMapping("/Admin/realDelete/postKereta")
    public String adminSidinDeletespecificPostkereta(dataTiketkereta newData, Model model) {
        if(!dataTiket.checkIDkereta(newData.getId())){
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '1');
            model.addAttribute("Error", "Id tidak ditemukan");
            return "deleteTicket";
        }
        dataTiket.removeKereta(newData.getId());;
        model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '1');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil delete tiket keretanya");
        return "deleteTicket";
    }

    @PostMapping("/Admin/realDelete/postBus")
    public String adminSidinDeletepecificPostbus(dataTiketbus newData, Model model) {
        if(!dataTiket.checkIDbus(newData.getId())){
            model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
            model.addAttribute("code", '2');
            model.addAttribute("Error", "Id tidak ditemukan");
            return "deleteTicket";
        }
        dataTiket.removeBus(newData.getId());
        model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
        model.addAttribute("code", '2');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil delete tiket Busnya");
        return "deleteTicket";
    }


    @GetMapping("/Admin/Update")
    public String adminSidinUpdatemenu(Model model) {
        return "adminUpdatemenu";
    }

    @GetMapping("/Admin/realUpdate/{param}")
    public String adminSidinUpdatespecific(@PathVariable("param") String param, Model model) {
        if (param.equals("Bus")) {
            model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
            model.addAttribute("code", '2');
        } else if (param.equals("Kereta")) {
            model.addAttribute("newData", new dataTiketkereta(0, "", "", "", "", "0", 0, 0));
            model.addAttribute("code", '1');
        } else if (param.equals("Pesawat")) {
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '0');
        }
        return "updateTicket";
    }

    @PostMapping("/Admin/realUpdate/postPesawat")
    public String adminSidinUpdatespecificPostpesawat(dataTiketpesawat newData, Model model) {
        if(!dataTiket.checkIDpesawat(newData.getId())){
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '0');
            model.addAttribute("Error", "Id tidak ditemukan");
            return "updateTicket";
        }
        dataTiket.removePesawat(newData.getId());
        dataTiket.addPesawat(newData);
        model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
        model.addAttribute("code", '0');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil update tiket pesawatnya");
        return "updateTicket";
    }

    @PostMapping("/Admin/realUpdate/postKereta")
    public String adminSidinUpdatespecificPostkereta(dataTiketkereta newData, Model model) {
        if(!dataTiket.checkIDkereta(newData.getId())){
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '1');
            model.addAttribute("Error", "Id tidak ditemukan");
            return "updateTicket";
        }
        dataTiket.removeKereta(newData.getId());
        dataTiket.addKereta(newData);
        model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '1');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil update tiket keretanya");
        return "updateTicket";
    }

    @PostMapping("/Admin/realUpdate/postBus")
    public String adminSidinUpdatespecificPostbus(dataTiketbus newData, Model model) {
        if(!dataTiket.checkIDbus(newData.getId())){
            model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
            model.addAttribute("code", '2');
            model.addAttribute("Error", "Id tidak ditemukan");
            return "updateTicket";
        }
        dataTiket.removeBus(newData.getId());
        dataTiket.addBus(newData);
        model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
        model.addAttribute("code", '2');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil update tiket Busnya");
        return "updateTicket";
    }

    @GetMapping("/Admin/Add")
    public String adminSidinAddmenu(Model model) {
        return "adminAddmenu";
    }

    @GetMapping("/Admin/realAdd/{param}")
    public String adminSidinAddspecific(@PathVariable("param") String param, Model model) {
        if (param.equals("Bus")) {
            model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
            model.addAttribute("code", '2');
        } else if (param.equals("Kereta")) {
            model.addAttribute("newData", new dataTiketkereta(0, "", "", "", "", "0", 0, 0));
            model.addAttribute("code", '1');
        } else if (param.equals("Pesawat")) {
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '0');
        }
        return "addTicket";
    }

    @PostMapping("/Admin/realAdd/postPesawat")
    public String adminSidinAddspecificPostpesawat(dataTiketpesawat newData, Model model) {
        if(dataTiket.checkIDpesawat(newData.getId())){
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '0');
            model.addAttribute("Error", "Id sudah terpakai");
            return "addTicket";
        }
        dataTiket.addPesawat(newData);
        model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
        model.addAttribute("code", '0');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket pesawatnya");
        return "addTicket";
    }

    @PostMapping("/Admin/realAdd/postKereta")
    public String adminSidinAddspecificPostkereta(dataTiketkereta newData, Model model) {
        if(dataTiket.checkIDkereta(newData.getId())){
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '1');
            model.addAttribute("Error", "Id sudah terpakai");
            return "addTicket";
        }
        dataTiket.addKereta(newData);
        model.addAttribute("newData", new dataTiketkereta(0, "", "", "", "", "0", 0, 0));
        model.addAttribute("code", '1');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket keretanya");
        return "addTicket";
    }

    @PostMapping("/Admin/realAdd/postBus")
    public String adminSidinAddspecificPostbus(dataTiketbus newData, Model model) {
        if(dataTiket.checkIDbus(newData.getId())){
            model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
            model.addAttribute("code", '2');
            model.addAttribute("Error", "Id tidak ditemukan");
            return "addTicket";
        }
        dataTiket.addBus(newData);
        model.addAttribute("newData", new dataTiketbus(0, "", "", "", "", "0", 0));
        model.addAttribute("code", '2');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil tambah tiket Busnya");
        return "addTicket";
    }

    @GetMapping("/logout")
    public String Logout(Model model) {
        dataUser.nowisLogout();
        return "redirect:/";
    }

    @GetMapping("/payment")
    public String payment(Model model) {
        return "payment";

    }
}