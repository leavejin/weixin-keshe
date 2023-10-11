package com.dada.dao;


import com.dada.pojo.Admin;
import com.dada.pojo.NetAdmin;

public interface NetAdminMapper {

    //添加一个用户
    int addNetAdmin(NetAdmin netAdmin);

    NetAdmin queryNetAdminByNumber(String netAdminNumber);
}
