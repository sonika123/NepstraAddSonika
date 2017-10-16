package com.sonika.nepstra.pojo;

/**
 * Created by sonika on 10/16/2017.
 */

public class Newarrivals_pojo {
    public String newname, newprice, newimage;
    public Integer newid;
    public Integer newcid;

    public Newarrivals_pojo() {
    }

    public Newarrivals_pojo(String newname, String newprice, String newimage, Integer newid, Integer newcid) {
        this.newname = newname;
        this.newprice = newprice;
        this.newimage = newimage;
        this.newid = newid;
        this.newcid = newcid;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public String getNewprice() {
        return newprice;
    }

    public void setNewprice(String newprice) {
        this.newprice = newprice;
    }

    public String getNewimage() {
        return newimage;
    }

    public void setNewimage(String newimage) {
        this.newimage = newimage;
    }

    public Integer getNewid() {
        return newid;
    }

    public void setNewid(Integer newid) {
        this.newid = newid;
    }

    public Integer getNewcid() {
        return newcid;
    }

    public void setNewcid(Integer newcid) {
        this.newcid = newcid;
    }
}
