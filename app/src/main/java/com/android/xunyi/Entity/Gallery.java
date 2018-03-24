package com.android.xunyi.Entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */

public class Gallery {
    List<Integer> list;
    private String name;
    private String place;
    private String time;

    public Gallery(List<Integer> list, String name, String place, String time) {
        this.list = list;
        this.name = name;
        this.place = place;
        this.time = time;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
