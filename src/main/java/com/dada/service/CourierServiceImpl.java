package com.dada.service;

import com.dada.dao.CourierMapper;
import com.dada.dao.UserMapper;
import com.dada.pojo.Courier;
import com.dada.pojo.Users;

import java.util.List;


public class CourierServiceImpl implements CourierService{

    private CourierMapper courierMapper;

    public void setCourierMapper(CourierMapper courierMapper) {
        this.courierMapper = courierMapper;
    }

    public int addCourier(Courier courier) {
        return courierMapper.addCourier(courier);
    }

    public int deleteCourierById(int id) {
        return courierMapper.deleteCourierById(id);
    }

    public int deleteCourierByNumber(String courierNumber) {
        return courierMapper.deleteCourierByNumber(courierNumber);
    }

    public int updateCourier(Courier courier) {
        return courierMapper.updateCourier(courier);
    }

    public Courier queryCourierById(int id) {
        return courierMapper.queryCourierById(id);
    }

    public List<Courier> queryAllCourier() {
        return courierMapper.queryAllCourier();
    }

    public Courier queryCourierByNumber(String courierNumber) {
        return courierMapper.queryCourierByNumber(courierNumber);
    }

    public List<Courier> queryCourierLike(String courierSite) {
        return courierMapper.queryCourierLike(courierSite);
    }

}
