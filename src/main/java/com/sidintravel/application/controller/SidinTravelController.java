package com.sidintravel.application.controller;

import java.util.ArrayList;

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

    @GetMapping("/buyticket/{param1}/{param2}")
    public String buyTicketget(@PathVariable("param1") String param1, @PathVariable("param2") String param2,
            datareservasi dataRes, Model model) {
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "error";
        }

        model.addAttribute("newBuy", new datareservasi("", 0, 0, 0));
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        if (param1.equals("bus")) {
            model.addAttribute("tickets", dataTiket.showBuyBis(Integer.parseInt(param2)));
            model.addAttribute("code", '2');
        } else if (param1.equals("kereta")) {
            model.addAttribute("tickets", dataTiket.showBuyKereta(Integer.parseInt(param2)));
            model.addAttribute("code", '1');
        } else if (param1.equals("pesawat")) {
            model.addAttribute("tickets", dataTiket.showBuyPesawat(Integer.parseInt(param2)));
            model.addAttribute("code", '0');
        }
        return "custBook";
    }

    @PostMapping("/buyticket/{param1}/{param2}")
    public String buyTicketpost(@PathVariable("param1") String param1, @PathVariable("param2") String param2,
            datareservasi dataRes, Model model) {
        model.addAttribute("dataRes", dataRes);
        if (param1.equals("bus")) {
            dataRes.setidCode(2);
            dataRes.setidTiket(Integer.parseInt(param2));
        } else if (param1.equals("kereta")) {
            dataRes.setidCode(1);
            dataRes.setidTiket(Integer.parseInt(param2));
        } else if (param1.equals("pesawat")) {
            dataRes.setidCode(0);
            dataRes.setidTiket(Integer.parseInt(param2));
        }
        bookData.addBooking(dataRes);
        return "redirect:/home";
    }

    @GetMapping("/myBooking")
    public String myBooking(Model model) {
        Boolean isLogin = dataUser.checkisLogin();
        if (!isLogin) {
            return "error";
        }

        ArrayList<dataTiketbus> tempBus = new ArrayList<>();
        ArrayList<dataTiketkereta> tempKereta = new ArrayList<>();
        ArrayList<dataTiketpesawat> tempPesawat = new ArrayList<>();
        ArrayList<datareservasi> tempReservasiBus = new ArrayList<>();
        ArrayList<datareservasi> tempReservasiKereta = new ArrayList<>();
        ArrayList<datareservasi> tempReservasiPesawat = new ArrayList<>();
        for (int i = 0; i < bookData.getSize(); i++) {
            Integer tempidCode = bookData.showBooking().get(i).getidCode();
            if (tempidCode == 2) {
                tempBus.add(dataTiket.showBuyBis(bookData.showBooking().get(i).getidTiket()));
                tempReservasiBus.add(bookData.showBuyBookingBus(bookData.showBooking().get(i).getidTiket()));
            } else if (tempidCode == 1) {
                tempKereta.add(dataTiket.showBuyKereta(bookData.showBooking().get(i).getidTiket()));
                tempReservasiKereta.add(bookData.showBuyBookingKereta(bookData.showBooking().get(i).getidTiket()));
            } else if (tempidCode == 0) {
                tempPesawat.add(dataTiket.showBuyPesawat(bookData.showBooking().get(i).getidTiket()));
                tempReservasiPesawat.add(bookData.showBuyBookingPesawat(bookData.showBooking().get(i).getidTiket()));
            }
        }
        model.addAttribute("tempBus", tempBus);
        model.addAttribute("tempBookingBus", tempReservasiBus);
        model.addAttribute("tempKereta", tempKereta);
        model.addAttribute("tempBookingKereta", tempReservasiKereta);
        model.addAttribute("tempPesawat", tempPesawat);
        model.addAttribute("tempBookingPesawat", tempReservasiPesawat);
        return "mybook";
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
        if (!dataTiket.checkIDpesawat(newData.getId())) {
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
        if (!dataTiket.checkIDkereta(newData.getId())) {
            model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
            model.addAttribute("code", '1');
            model.addAttribute("Error", "Id tidak ditemukan");
            return "deleteTicket";
        }
        dataTiket.removeKereta(newData.getId());
        ;
        model.addAttribute("newData", new dataTiketpesawat(0, "", "", "", "", "0", 0, 0, 0));
        model.addAttribute("code", '1');
        model.addAttribute("Success", "SSSIIIIUUUUU Berhasil delete tiket keretanya");
        return "deleteTicket";
    }

    @PostMapping("/Admin/realDelete/postBus")
    public String adminSidinDeletepecificPostbus(dataTiketbus newData, Model model) {
        if (!dataTiket.checkIDbus(newData.getId())) {
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
        if (!dataTiket.checkIDpesawat(newData.getId())) {
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
        if (!dataTiket.checkIDkereta(newData.getId())) {
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
        if (!dataTiket.checkIDbus(newData.getId())) {
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
        if (dataTiket.checkIDpesawat(newData.getId())) {
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
        if (dataTiket.checkIDkereta(newData.getId())) {
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
        if (dataTiket.checkIDbus(newData.getId())) {
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
}