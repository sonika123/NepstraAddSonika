package com.sonika.nepstra.pojo;

/**
 * Created by sonika on 10/17/2017.
 */

public class Mens_pojo {
    public String menname, menprice, menimage;
    public Integer menid;
    public Integer mencid;

    public Mens_pojo(String menname, String menprice, String menimage, Integer menid, Integer mencid) {

        this.menname = menname;
        this.menprice = menprice;
        this.menimage = menimage;
        this.menid = menid;
        this.mencid = mencid;
    }
    public Mens_pojo() {
    }

    public String getMenname() {
        return menname;
    }

    public void setMenname(String menname) {
        this.menname = menname;
    }

    public String getMenprice() {
        return menprice;
    }

    public void setMenprice(String menprice) {
        this.menprice = menprice;
    }

    public String getMenimage() {
        return menimage;
    }

    public void setMenimage(String menimage) {
        this.menimage = menimage;
    }

    public Integer getMenid() {
        return menid;
    }

    public void setMenid(Integer menid) {
        this.menid = menid;
    }

    public Integer getMencid() {
        return mencid;
    }

    public void setMencid(Integer mencid) {
        this.mencid = mencid;
    }


}
