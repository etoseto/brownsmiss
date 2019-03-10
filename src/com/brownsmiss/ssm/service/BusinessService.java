package com.brownsmiss.ssm.service;

import com.brownsmiss.ssm.pojo.Business;

import java.util.List;

/**
 * 商品数据表业务逻辑接口
 */
public interface BusinessService {
    //查询所有商品
    List<Business> getBusiness();
    //通过id查询
    Business getBusinessById(Integer id);
    //修改
    void updateBusiness(Business business);
    //删除
    void deleteBusiness(Integer id);
    //添加
    void addBusiness(Business business);
}