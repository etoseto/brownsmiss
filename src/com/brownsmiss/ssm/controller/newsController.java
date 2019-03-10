package com.brownsmiss.ssm.controller;

import com.brownsmiss.ssm.pojo.News;
import com.brownsmiss.ssm.service.NewsServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 新闻信息请求处理
 */
@Controller
@RequestMapping("news")
public class newsController {

    @Autowired
    private NewsServic newsServic;

    //获取news列表
    @RequestMapping("list")
    @ResponseBody
    public List<News> list(HttpServletRequest request){
//        HttpSession session = request.getSession();
//        if(session.getAttribute("logined").equals("success")){
//
//        }
        List<News> newsList = newsServic.getNewsList();
        return newsList;
    }
    //通过Id获取news
    @RequestMapping("item")
    @ResponseBody
    public News item(@RequestParam("id") Integer id){
        System.out.println("前台传输的数据:"+id);
        News news = newsServic.getNews(id);
        return  news;
    }
    //修改 1 失败 ,0 成功
    @RequestMapping(value = "edit",method = RequestMethod.POST)
    @ResponseBody
    public String edit(News news){
        System.out.println("前台修改参数提交:"+news);
        String msg = "1";
        try{
            //newsServic.updateNews(news);
            newsServic.editeNews(news);
            msg = "0";
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }

    //修改 1 失败 ,0 成功
//    @RequestMapping("edit")
//    @ResponseBody
//    public String edit(@RequestParam Integer id, @RequestParam String newsname, @RequestParam String author, @RequestParam Date time, @RequestParam String newsdetails){
//        News news = new News();
//        news.setId(id);
//        news.setNewsname(newsname);
//        news.setAuthor(author);
//        news.setTime(time);
//        news.setNewsdetails(newsdetails);
//        System.out.println("前台修改参数提交:"+news);
//        String msg = "1";
//        try{
//            //newsServic.updateNews(news);
//            newsServic.editeNews(news);
//            msg = "0";
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return msg;
//    }

    //删除
    @RequestMapping("delete")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id){
        String msg = "1";
        try{
            newsServic.deleteNews(id);
            msg = "0";
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }

    //添加
    @RequestMapping("add")
    @ResponseBody
    public String add(News news){
        System.out.println("添加信息:" + news);
        String msg = "1";
        try{
            newsServic.addNews(news);
            msg = "0";
        }catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }
}
