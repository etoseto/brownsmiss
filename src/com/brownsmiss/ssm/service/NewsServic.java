package com.brownsmiss.ssm.service;

import com.brownsmiss.ssm.pojo.News;

import java.util.List;

/**
 * 新闻数据表业务逻辑接口
 */
public interface NewsServic {

    //查询所有新闻
    List<News> getNewsList();

    //通过id查询
    News getNews(Integer id);
    //修改信息
    void updateNews(News news);
    void editeNews(News news);
    //删除
    void deleteNews(Integer id);
    //添加
    void addNews(News news);

}
