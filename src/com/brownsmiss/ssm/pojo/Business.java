package com.brownsmiss.ssm.pojo;

public class Business {
    private Integer id;

    private String businessname;

    private String img;

    private String url;

    private String businessdetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname == null ? null : businessname.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBusinessdetails() {
        return businessdetails;
    }

    public void setBusinessdetails(String businessdetails) {
        this.businessdetails = businessdetails == null ? null : businessdetails.trim();
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", businessname='" + businessname + '\'' +
                ", img='" + img + '\'' +
                ", url='" + url + '\'' +
                ", businessdetails='" + businessdetails + '\'' +
                '}';
    }
}