package com.dada.controller;

import com.alibaba.fastjson.JSONObject;
import com.dada.pojo.Admin;
import com.dada.pojo.Courier;
import com.dada.pojo.Mail;
import com.dada.pojo.NetAdmin;
import com.dada.service.CourierService;
import com.dada.service.MailService;
import com.dada.service.NetAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/netadmin")
public class NetAdminController {

    @Autowired
    @Qualifier("NetAdminServiceImpl")
    private NetAdminService netAdminService;

    @Autowired
    @Qualifier("CourierServiceImpl")
    private CourierService courierService;

    @Autowired
    @Qualifier("MailServiceImpl")
    private MailService mailService;

    @ResponseBody
    @RequestMapping(value ="/login",produces = "text/plain;charset=utf-8")
    public String login(@RequestBody String netadminno, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(netadminno);
        String netAdminNumber = jsonObject.getString("netAdminNumber");
        String netAdminPassword = jsonObject.getString("netAdminPassword");
        NetAdmin netAdmin = netAdminService.queryNetAdminByNumber(netAdminNumber);
        if (netAdmin == null) return "0";
        else {
            System.out.println("courierPassword==>" + netAdminPassword);
            System.out.println("courier.getCourierPassword()==>" + netAdmin.getNetadminPassword());
            if (netAdmin.getNetadminPassword().equals(netAdminPassword)) return "1";
            else return "2";
        }
    }

    @ResponseBody
    @RequestMapping(value ="/showAllCourier",produces = "text/plain;charset=utf-8")
    public String showAllCourier(@RequestBody String uid, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(uid);
        String netAdminNumber = jsonObject.getString("netAdminNumber");
        NetAdmin netAdmin = netAdminService.queryNetAdminByNumber(netAdminNumber);
        String siteName = netAdmin.getDotName();
        List<Courier> couriers = courierService.queryCourierLike(siteName);
        String res = JSONObject.toJSONString(couriers);
        System.out.println(res);
        return res;
    }

    @ResponseBody
    @RequestMapping(value ="/showMail",produces = "text/plain;charset=utf-8")
    public String showMail(@RequestBody String uid, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(uid);
        String netAdminNumber = jsonObject.getString("netAdminNumber");
        NetAdmin netAdmin = netAdminService.queryNetAdminByNumber(netAdminNumber);
        String siteName = netAdmin.getDotName();
        List<Mail> mail = mailService.queryMailBySite(siteName);
        String res = JSONObject.toJSONString(mail);
        return res;
    }


}