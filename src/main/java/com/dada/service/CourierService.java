package com.dada.service;

import com.dada.pojo.Courier;
import com.dada.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourierService {
    //添加一个用户
    int addCourier(Courier courier);
    //删除一个用户
    int deleteCourierById(@Param("courierID") int id);

    int deleteCourierByNumber(@Param("courierNumber") String courierNumber);

    //更新一个用户信息
    int updateCourier(Courier courier);
    //查询一个用户信息
    Courier queryCourierById(@Param("courierID") int id);
    //查询全部用户
    List<Courier> queryAllCourier();
    Courier queryCourierByNumber(String courierNumber);

    List<Courier> queryCourierLike(@Param("courierSite") String courierSite);
}
