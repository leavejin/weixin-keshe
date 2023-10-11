package com.dada.controller;

import com.alibaba.fastjson.JSONObject;
import com.dada.pojo.Courier;
import com.dada.pojo.Mail;
import com.dada.pojo.NetAdmin;
import com.dada.pojo.Users;
import com.dada.service.MailService;
import com.dada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    @Qualifier("MailServiceImpl")
    private MailService mailService;

    //用户寄快递页面
    @ResponseBody
    @RequestMapping(value = "/send",produces = "text/plain;charset=utf-8")
    public String send(@RequestBody String mail, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(mail);
        Mail mail1 = JSONObject.parseObject(mail, Mail.class);
        System.out.println(mail1);
        mailService.addMail(mail1);
        return "1";
    }

    //用户查快递页面
    @ResponseBody
    @RequestMapping(value = "/search",produces = "text/plain;charset=utf-8")
    public String search(@RequestBody String id, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(id);
        String kid = jsonObject.getString("kid");
        Mail mail = mailService.queryMailById(Integer.parseInt(kid));
        System.out.println(mail);
        if ("1".equals(mail.getSj())) return "ysj";
        String res = JSONObject.toJSONString(mail);
        return res;
    }
    //管理员 查询还没有网点的快递
    @ResponseBody
        @RequestMapping(value = "/showMail",produces = "text/plain;charset=utf-8")
    public String showMail(@RequestBody String id, Model model) {
//        JSONObject jsonObject = JSONObject.parseObject(id);
//        String kid = jsonObject.getString("kid");
//        Mail mail = mailService.queryMailById(Integer.parseInt(kid));
        List<Mail> mail1 = mailService.queryAllMail();
        for (int i = 0; i < mail1.size(); i ++ ) {
            Mail mail = mail1.get(i);
            if (mail.getDotName()!= null &&  !"".equals(mail.getDotName())) {
                mail1.remove(i);
                i--;
            }
        }
        String res = JSONObject.toJSONString(mail1);
        return res;
    }
    //管理员 分配网点
    @ResponseBody
    @RequestMapping(value = "/fpwd",produces = "text/plain;charset=utf-8")
    public String fpwd(@RequestBody String id, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(id);
        String kid = jsonObject.getString("kid");
        String dotName = jsonObject.getString("dotName");
        Mail mail = mailService.queryMailById(Integer.parseInt(kid));
        mail.setDotName(dotName);
        System.out.println("mail.setDotName(dotName);==>" + mail);
        int i = mailService.updateMail(mail);
        return ""+i;
    }
    //确认收获
    @ResponseBody
    @RequestMapping(value = "/qrsh",produces = "text/plain;charset=utf-8")
    public String qrsh(@RequestBody String uid, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(uid);
        String kid = jsonObject.getString("kid");
        Mail mail = mailService.queryMailById(Integer.parseInt(kid));
        mail.setSj("1");
        int i = mailService.updateMail(mail);
        return ""+i;
    }


    //确认揽件
    @ResponseBody
    @RequestMapping(value = "/qrlj",produces = "text/plain;charset=utf-8")
    public String qrlj(@RequestBody String uid, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(uid);
        String kid = jsonObject.getString("kid");
        Mail mail = mailService.queryMailById(Integer.parseInt(kid));
        if ("1".equals(mail.getLj())) return "0";
        mail.setLj("1");
        int i = mailService.updateMail(mail);
        return ""+i;
    }

    //快递 选择 快递员
    @ResponseBody
    @RequestMapping(value = "/selectCourier",produces = "text/plain;charset=utf-8")
    public String selectCourier(@RequestBody String uid, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(uid);
        String kid = jsonObject.getString("kid");
        String courierNumber = jsonObject.getString("courierNumber");
        Mail mail = mailService.queryMailById(Integer.parseInt(kid));
        mail.setCourierName(courierNumber);
        int i = mailService.updateMail(mail);
        if (i == 0) return "0";
        else return "1";
    }

    @ResponseBody
    @RequestMapping(value ="/selectMailByCourier",produces = "text/plain;charset=utf-8")
    public String selectMailByCourier(@RequestBody String uid, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(uid);
        String courierNumber = jsonObject.getString("courierNumber");
        List<Mail> mail1 = mailService.selectMailByCourierNumber(courierNumber);
        for (int i = 0; i < mail1.size(); i ++ ) {
            Mail mail = mail1.get(i);
            if ("1".equals(mail.getSj())) {
                mail1.remove(i);
                i--;
            }
        }
        String res = JSONObject.toJSONString(mail1);
        return res;
    }
}