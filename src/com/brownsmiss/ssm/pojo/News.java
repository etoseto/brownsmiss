package com.brownsmiss.ssm.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class News {
    private Integer id;

    private String newsname;

    private String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String newsdetails;
    public News(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname == null ? null : newsname.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNewsdetails() {
        return newsdetails;
    }

    public void setNewsdetails(String newsdetails) {
        this.newsdetails = newsdetails == null ? null : newsdetails.trim();
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsname='" + newsname + '\'' +
                ", author='" + author + '\'' +
                ", time=" + time +
                ", newsdetails='" + newsdetails + '\'' +
                '}';
    }
}