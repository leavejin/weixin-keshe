package com.dada.service;

import com.dada.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //添加一个用户
    int addUser(Users users);
    //删除一个用户
    int deleteUserById(@Param("userId") int id);
    //更新一个用户信息
    int updateUser(Users users);
    //查询一个用户信息
    Users queryUserById(@Param("userId") int id);
    //查询全部用户
    List<Users> queryAllUser();

    Users queryUserByNumber(String userNumber);

}
