package com.brownsmiss.ssm.service;

import com.brownsmiss.ssm.pojo.Admin;

import java.util.List;

/**
 * 管理员数据表业务逻辑接口
 */
public interface AdminService {

    //传入用户信息查询是否存在
    List<Admin> getAdminCountByAdmin();

    //查询用户信息
    Admin getAdminById(Integer id);

    //更新
    void updateAdmin(Admin admin);

    //删除
    void deleteAdmin(Integer id);

    //添加
    void addAdmin(Admin admin);
}
