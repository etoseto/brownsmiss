package com.brownsmiss.ssm.controller;

import com.brownsmiss.ssm.pojo.Business;
import com.brownsmiss.ssm.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品信息请求处理
 */
@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("list")
    public String list(Model model)throws Exception{
        List<Business> business = businessService.getBusiness();
        model.addAttribute("item",business);
        return "item";
    }


    //输出json,通过商品id返回
    @RequestMapping("business")
    @ResponseBody
    public Business business(@RequestParam("id") Integer id)throws Exception{
        System.out.println("前台传输的数据id:"+id);
        Business business = businessService.getBusinessById(id);
        return business;
    }
    //输出json,返回所有商品
    @RequestMapping("businessList")
    @ResponseBody
    public List<Business> businessList()throws Exception{
        List<Business> business = businessService.getBusiness();
        return business;
    }

    //更新商品信息,0 表示成功
    @RequestMapping("update")
    @ResponseBody
    public String update(Business business)throws Exception{
        System.out.println("前台Business数据:" + business);
        String msg = "1";
        try{
            businessService.updateBusiness(business);
            msg = "0";
        }catch(Exception e){
            e.printStackTrace();
        }
        return msg;
    }

    //删除
    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id){
        System.out.println("前台Business id数据:" + id);
        String msg = "1";
        try{
            businessService.deleteBusiness(id);
            msg = "0";
        }catch(Exception e){
            e.printStackTrace();
        }
        return msg;
    }

    //添加
    @RequestMapping("add")
    @ResponseBody
    public String add(Business business){
        System.out.println("前台Business对象数据:" + business);
        String msg = "1";
        try{
            businessService.addBusiness(business);
            msg = "0";
        }catch(Exception e){
            e.printStackTrace();
        }
        return msg;
    }

}
