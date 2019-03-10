package com.brownsmiss.ssm.controller;

import com.brownsmiss.ssm.pojo.Admin;
import com.brownsmiss.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("access")
public class loginController {
    @Autowired
    private AdminService adminService;

    //获取全部Admin
    @RequestMapping(value = "list")
    @ResponseBody
    public List<Admin> list()throws Exception{
        List<Admin> adminCountByAdmin = adminService.getAdminCountByAdmin();
        return adminCountByAdmin;
    }

    //通过Id查询
    @RequestMapping("getAdmin")
    @ResponseBody
    public Admin getAdmin(@RequestParam("id") Integer id){
        System.out.println("getAdmin信息"+ id);
        Admin adminById = adminService.getAdminById(id);
        return adminById;
    }

    //login
    @RequestMapping(value = "login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request)throws Exception{

        System.out.println("用户名:"+  username+"密码:"+password);
        List<Admin> adminCountByAdmin = adminService.getAdminCountByAdmin();
        System.out.println(adminCountByAdmin);
        String msg = "1";
        for(Admin admin : adminCountByAdmin){
//            System.out.println(admin.getName());
//            System.out.println(admin.getPassword());
            if(admin.getName().equals(username)  && admin.getPassword().equals(password) ){
                msg = "0";
//                HttpSession session = request.getSession(true);
//                System.out.println(session);
//                session.setAttribute("logined","success");
//
//                System.out.println(session.getAttribute("username"));
            }
            System.out.println(msg);
            System.out.println(admin);
        }
        return msg;
    }

    //更新
    @RequestMapping("update")
    @ResponseBody
    public String update(Admin admin){
        String msg = "1";
        try{
            adminService.updateAdmin(admin);
            msg = "0";
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }

    //删除
    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id){
        String msg = "1";
        try{
            adminService.deleteAdmin(id);
            msg = "0";
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }

    //添加
    @RequestMapping("add")
    @ResponseBody
    public String add(Admin admin){
        System.out.println("添加信息:" + admin);
        String msg = "1";
        try{
            adminService.addAdmin(admin);
            msg = "0";
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }
}
