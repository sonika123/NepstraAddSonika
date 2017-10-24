package com.sonika.nepstra.pojo;

/**
 * Created by sonika on 10/18/2017.
 */

public class Sports_pojo {

    public String sportsname, sportsprice, sportsimage;
    public Integer sportsid;
    public Integer sportscid;

    public Sports_pojo() {
    }

    public Sports_pojo(String sportsname, String sportsprice, String sportsimage, Integer sportsid, Integer sportscid) {
        this.sportsname = sportsname;
        this.sportsprice = sportsprice;
        this.sportsimage = sportsimage;
        this.sportsid = sportsid;
        this.sportscid = sportscid;
    }

    public String getSportsname() {
        return sportsname;
    }

    public void setSportsname(String sportsname) {
        this.sportsname = sportsname;
    }

    public String getSportsprice() {
        return sportsprice;
    }

    public void setSportsprice(String sportsprice) {
        this.sportsprice = sportsprice;
    }

    public String getSportsimage() {
        return sportsimage;
    }

    public void setSportsimage(String sportsimage) {
        this.sportsimage = sportsimage;
    }

    public Integer getSportsid() {
        return sportsid;
    }

    public void setSportsid(Integer sportsid) {
        this.sportsid = sportsid;
    }

    public Integer getSportscid() {
        return sportscid;
    }

    public void setSportscid(Integer sportscid) {
        this.sportscid = sportscid;
    }
}

