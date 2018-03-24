package com.android.xunyi.Entity;

/**
 * Created by Administrator on 2017/3/15.
 */

public class Ysys {
    private int imageId;
    private String name ;
    private String price;

    public Ysys(int imageId, String name, String price) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
