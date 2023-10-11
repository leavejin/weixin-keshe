package com.dada.controller;

import com.alibaba.fastjson.JSONObject;
import com.dada.pojo.Courier;
import com.dada.pojo.Mail;
import com.dada.pojo.NetAdmin;
import com.dada.pojo.Users;
import com.dada.service.CourierService;
import com.dada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
    @RequestMapping("/courier")
public class CourierController {

    @Autowired
    @Qualifier("CourierServiceImpl")
    private CourierService courierService;

    @ResponseBody
    @RequestMapping(value ="/login",produces = "text/plain;charset=utf-8")
    public String login(@RequestBody String courierno, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(courierno);
        String courierNumber = jsonObject.getString("courierNumber");
        String courierPassword = jsonObject.getString("courierPassword");
        Courier courier = courierService.queryCourierByNumber(courierNumber);
        if (courier == null) return "0";
        else {
            System.out.println("courierPassword==>" + courierPassword);
            System.out.println("courier.getCourierPassword()==>" + courier.getCourierPassword());
            if (courier.getCourierPassword().equals(courierPassword)) return "1";
            else return "2";
        }
    }
    @ResponseBody
    @RequestMapping(value = "/register",produces = "text/plain;charset=utf-8")
    public String register(@RequestBody String userno, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(userno);
        String courierNumber = jsonObject.getString("courierNumber");
        String courierName = jsonObject.getString("courierName");
        String courierPassword = jsonObject.getString("courierPassword");
        String courierSite = jsonObject.getString("courierSite");
        if (courierService.queryCourierByNumber(courierNumber) != null) return "0";
        courierService.addCourier(new Courier(1,courierName, courierPassword, courierNumber, courierSite));
//        String res = JSONObject.toJSONString(userService.queryUserByNumber(userNumber));
        return "1";
    }
    @ResponseBody
    @RequestMapping(value ="/deleteByNumber",produces = "text/plain;charset=utf-8")
    public String deleteByNumber(@RequestBody String number, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(number);
        String courierNumber = jsonObject.getString("courierNumber");
        System.out.println("要删除的快递员==》" + courierNumber);
        int i = courierService.deleteCourierByNumber(courierNumber);
        System.out.println(i);
        if (i == 0) return "0";
        else return "1";
    }

//    @ResponseBody
//    @RequestMapping(value ="/showMail",produces = "text/plain;charset=utf-8")
//    public String showMail(@RequestBody String uid, Model model) {
//        JSONObject jsonObject = JSONObject.parseObject(uid);
//        String netAdminNumber = jsonObject.getString("netAdminNumber");
//        NetAdmin netAdmin = netAdminService.queryNetAdminByNumber(netAdminNumber);
//        String siteName = netAdmin.getDotName();
//        List<Mail> mail = mailService.queryMailBySite(siteName);
//        String res = JSONObject.toJSONString(mail);
//        return res;
//    }

    @RequestMapping("/allCourier")
    public String list(Model model) {
        List<Courier> list = courierService.queryAllCourier();
        model.addAttribute("list", list);
        return "allUser";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model) {
        List<Courier> list = courierService.queryAllCourier();
        model.addAttribute("list", list);
        return "allCourier";
    }

}