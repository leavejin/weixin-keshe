package com.dada.service;

import com.dada.pojo.Admin;
import com.dada.pojo.NetAdmin;

public interface NetAdminService {
    //添加一个用户
    int addNetAdmin(NetAdmin netAdmin);

    NetAdmin queryNetAdminByNumber(String netAdminNumber);
}
