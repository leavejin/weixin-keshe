package com.dada.service;

import com.dada.dao.UserMapper;
import com.dada.pojo.Users;

import java.util.List;


public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(Users users) {
        return userMapper.addUser(users);
    }

    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    public int updateUser(Users users) {
        return userMapper.updateUser(users);
    }

    public Users queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    public List<Users> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public Users queryUserByNumber(String userNumber) {return userMapper.queryUserByNumber(userNumber);}


}
