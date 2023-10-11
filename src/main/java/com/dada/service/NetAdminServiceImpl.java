package com.dada.service;

import com.dada.dao.NetAdminMapper;
import com.dada.pojo.Admin;
import com.dada.pojo.NetAdmin;


public class NetAdminServiceImpl implements NetAdminService {

    private NetAdminMapper netAdminMapper;

    public void setNetAdminMapper(NetAdminMapper netAdminMapper) {
        this.netAdminMapper = netAdminMapper;
    }

    public int addNetAdmin(NetAdmin netAdmin) {
        return netAdminMapper.addNetAdmin(netAdmin);
    }

    public NetAdmin queryNetAdminByNumber(String netAdminNumber) {
        return netAdminMapper.queryNetAdminByNumber(netAdminNumber);
    }
}
