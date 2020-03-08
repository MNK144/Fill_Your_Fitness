package com.manank.gymapp;

import java.io.Serializable;

public class MyListData implements Serializable {
    String id;
    String workout;
    String imgurl;


    public MyListData(String id, String workout,String imgurl) {
        this.id = id;
        this.workout = workout;
        this.imgurl = imgurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkout() {
        return workout;
    }

    public void setWorkout(String company) {
        this.workout = workout;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String company) {
        this.imgurl = imgurl;
    }

}
