package com.brownsmiss.ssm.service.impl;

import com.brownsmiss.ssm.mapper.BusinessMapper;
import com.brownsmiss.ssm.pojo.Business;
import com.brownsmiss.ssm.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> getBusiness() {
        return businessMapper.selectByExample(null);
    }

    @Override
    public Business getBusinessById(Integer id) {
        return businessMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBusiness(Business business) {
        businessMapper.updateByPrimaryKeySelective(business);
    }

    @Override
    public void deleteBusiness(Integer id) {
        businessMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addBusiness(Business business) {
        businessMapper.insert(business);
    }
}
