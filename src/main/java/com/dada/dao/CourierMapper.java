package com.dada.dao;


import com.dada.pojo.Courier;
import com.dada.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourierMapper {

    //添加一个用户
    int addCourier(Courier users);
    //删除一个用户
    int deleteCourierById(@Param("courierId") int id);

    int deleteCourierByNumber(@Param("courierNumber") String courierNumber);
    //更新一个用户信息
    int updateCourier(Courier users);
    //查询一个用户信息
    Courier queryCourierById(@Param("courierId") int id);
    //查询全部用户
    List<Courier> queryAllCourier();

    Courier queryCourierByNumber(String courierNumber);

    List<Courier> queryCourierLike(@Param("courierSite") String courierSite);

}
