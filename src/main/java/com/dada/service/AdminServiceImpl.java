package com.dada.service;

import com.dada.dao.AdminMapper;
import com.dada.dao.UserMapper;
import com.dada.pojo.Admin;
import com.dada.pojo.Users;

import java.util.List;


public class AdminServiceImpl implements AdminService{

    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public int addAdmin(Admin admin) {
        return adminMapper.addAdmin(admin);
    }

    public Admin queryAdminByNumber(String adminNumber) {
        return adminMapper.queryAdminByNumber(adminNumber);
    }
}
