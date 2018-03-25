package com.android.xunyi.Entity;

/**
 * Created by zsd19 on 2018/3/24.
 */

public class Company {
    private int id;
    private String name;
    private String brief;
    private int avatarId;
    private int imageId;

    public Company(int id, String name, String brief, int avatarId, int imageId) {
        this.id = id;
        this.name = name;
        this.brief = brief;
        this.avatarId = avatarId;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }
    public int getImageId () {
        return imageId;
    }

    public String getBrief() {
        return brief;
    }


    public String getName() {
        return name;
    }

    public int getAvatarId() {
        return avatarId;
    }

}
