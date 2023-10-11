package com.dada.controller;

import com.dada.pojo.Courier;
import com.dada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @RequestMapping("/jumplogin")
    public String jumplogin(@RequestParam("sf") String sf, Model model, HttpSession session) {
        session.setAttribute("sf", sf);
        return "login";
    }
    @RequestMapping("/loginJudge")
    public String loginJudge(@RequestParam("number") String number, @RequestParam("password") String password, @RequestParam("sf") String sf, Model model, HttpSession session) {
//        System.out.println(number + "   " + password + "    " + sf);
        model.addAttribute("number", number);
        model.addAttribute("password", password);
        return "redirect:/"+sf+"/login";
    }
}
