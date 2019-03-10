package com.brownsmiss.ssm.service.impl;

import com.brownsmiss.ssm.mapper.NewsMapper;
import com.brownsmiss.ssm.pojo.News;
import com.brownsmiss.ssm.service.NewsServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServicImpl implements NewsServic {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getNewsList() {
        return newsMapper.selectByExample(null);
    }



    @Override
    public News getNews(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateNews(News news) {
        newsMapper.updateNews(news);
    }

    @Override
    public void editeNews(News news) {
        newsMapper.updateByPrimaryKeyWithBLOBs(news);
    }

    @Override
    public void deleteNews(Integer id) {
        newsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addNews(News news) {
        newsMapper.insert(news);
    }

}
