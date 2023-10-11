package com.dada.dao;


import com.dada.pojo.Admin;
import com.dada.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    //添加一个用户
    int addAdmin(Admin admin);

    Admin queryAdminByNumber(String userNumber);
}
