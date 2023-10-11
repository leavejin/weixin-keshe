package com.dada.dao;


import com.dada.pojo.Mail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MailMapper {

    //添加
    int addMail(Mail mail);
    //删除一个用户
    int deleteMailById(@Param("kid") int kid);
    //更新一个用户信息
    int updateMail(Mail mail);
    //查询一个用户信息
    Mail queryMailById(@Param("kid") int kid);

    Mail queryMailByNumber(String senderNumber);

    //查询全部用户
    List<Mail> queryAllMail();

    List<Mail> queryMailBySite(@Param("dotName") String dotName);

    List<Mail> selectMailByCourierNumber(@Param("courierName") String courierName);

}
