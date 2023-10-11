package com.dada.service;

import com.dada.pojo.Mail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MailService {
    //添加
    int addMail(Mail mail);
    //删除一个用户
    int deleteMailById(@Param("kid") int kid);
    //更新一个用户信息
    int updateMail(Mail mail);
    //查询一个用户信息
    Mail queryMailById(@Param("kid") int kid);
    //查询全部用户
    List<Mail> queryAllMail();
    Mail queryMailByNumber(String senderNumber);

    List<Mail> queryMailBySite(String dotName);

    List<Mail> selectMailByCourierNumber(@Param("courierName") String courierName);

}
