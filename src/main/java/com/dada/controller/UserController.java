package com.dada.controller;

import com.alibaba.fastjson.JSONObject;
import com.dada.pojo.Mail;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;


    @ResponseBody
    @RequestMapping(value ="/login",produces = "text/plain;charset=utf-8")
    public String login(@RequestBody String userno, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(userno);
        String userNumber = jsonObject.getString("userNumber");
        String userPassword = jsonObject.getString("userPassword");
        Users user = userService.queryUserByNumber(userNumber);
        if (user == null) return "0";
        else {
            System.out.println("userPassword==>" + userPassword);
            System.out.println("user.getUserPassword()==>" + user.getUserPassword());
            if (user.getUserPassword().equals(userPassword)) return "1";
            else return "2";
        }
    }
    @ResponseBody
    @RequestMapping(value = "/register",produces = "text/plain;charset=utf-8")
    public String register(@RequestBody String userno, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(userno);
        String userName = jsonObject.getString("userName");
        String userNumber = jsonObject.getString("userNumber");
        String userPassword = jsonObject.getString("userPassword");
        String userAddress = jsonObject.getString("userAddress");
        if (userService.queryUserByNumber(userNumber) != null) return "0";
        userService.addUser(new Users(1,userName, userPassword, userNumber, userAddress));
//        String res = JSONObject.toJSONString(userService.queryUserByNumber(userNumber));
        return "1";
    }
    //user用户  “我的”页面
    @ResponseBody
    @RequestMapping(value = "/userMy",produces = "text/plain;charset=utf-8")
    public String userMy(@RequestBody String uid, Model model) {
        JSONObject jsonObject = JSONObject.parseObject(uid);
        String userNumber = jsonObject.getString("userNumber");
        Users user = userService.queryUserByNumber(userNumber);
        String res = JSONObject.toJSONString(userService.queryUserByNumber(userNumber));
        return res;
    }


    @RequestMapping("/allUser")
    public String list(Model model) {
        List<Users> list = userService.queryAllUser();
        model.addAttribute("list", list);
        return "allUser";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model) {
        List<Users> list = userService.queryAllUser();
        model.addAttribute("list", list);
        return "allUser";
    }

}