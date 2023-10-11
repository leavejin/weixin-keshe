package com.dada.service;

import com.dada.pojo.Admin;
import com.dada.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    //添加一个用户
    int addAdmin(Admin admin);

    Admin queryAdminByNumber(String adminNumber);
}
