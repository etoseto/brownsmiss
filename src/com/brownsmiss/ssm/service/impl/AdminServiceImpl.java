package com.brownsmiss.ssm.service.impl;

import com.brownsmiss.ssm.mapper.AdminMapper;
import com.brownsmiss.ssm.pojo.Admin;
import com.brownsmiss.ssm.pojo.AdminExample;
import com.brownsmiss.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> getAdminCountByAdmin() {

        return adminMapper.selectByExample(null);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.insert(admin);
    }


}
