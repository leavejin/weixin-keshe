package com.dada.service;

import com.dada.dao.MailMapper;
import com.dada.pojo.Mail;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public class MailServiceImpl implements MailService{

    private MailMapper mailMapper;

    public void setMailMapper(MailMapper mailMapper) {
        this.mailMapper = mailMapper;
    }

    public int addMail(Mail mail) {
        return mailMapper.addMail(mail);
    }

    public int deleteMailById(int kid) {
        return mailMapper.deleteMailById(kid);
    }

    public int updateMail(Mail mail) {
        return mailMapper.updateMail(mail);
    }

    public Mail queryMailById(int kid) {
        return mailMapper.queryMailById(kid);
    }

    public List<Mail> queryAllMail() {
        return mailMapper.queryAllMail();
    }

    public Mail queryMailByNumber(String senderNumber) {
        return mailMapper.queryMailByNumber(senderNumber);
    }

    public List<Mail> queryMailBySite(String dotName) {
        return mailMapper.queryMailBySite(dotName);
    }

    public List<Mail> selectMailByCourierNumber(String courierName) {
        return mailMapper.selectMailByCourierNumber(courierName);
    }
}
