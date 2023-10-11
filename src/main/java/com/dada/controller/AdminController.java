package com.dada.controller;

import com.alibaba.fastjson.JSONObject;
import com.dada.pojo.Admin;
import com.dada.pojo.Courier;
import com.dada.pojo.Users;
import com.dada.service.AdminService;
import com.dada.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @ResponseBody
    @RequestMapping(value ="/login",produces = "text/plain;charset=utf-8")
    public String login(@RequestBody String adminno, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(adminno);
        String adminNumber = jsonObject.getString("adminNumber");
        String adminPassword = jsonObject.getString("adminPassword");
        Admin admin = adminService.queryAdminByNumber(adminNumber);
        if (admin == null) return "0";
        else {
            System.out.println("courierPassword==>" + adminPassword);
            System.out.println("courier.getCourierPassword()==>" + admin.getAdminPassword());
            if (admin.getAdminPassword().equals(adminPassword)) return "1";
            else return "2";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/adminMy",produces = "text/plain;charset=utf-8")
    public String adminMy(@RequestBody String uid, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(uid);
        String adminNumber = jsonObject.getString("adminNumber");
        System.out.println(adminNumber);
        Admin admin = adminService.queryAdminByNumber(adminNumber);
        String res = JSONObject.toJSONString(adminService.queryAdminByNumber(adminNumber));
        System.out.println(res);
        return res;
    }

}