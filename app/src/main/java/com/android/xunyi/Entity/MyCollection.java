package com.android.xunyi.Entity;

/**
 * Created by zsd19 on 2018/3/25.
 */

public class MyCollection {
    public String name;
    public String avatarUrl;
    public String intro;
    public int imgHeight;

    public MyCollection(String name, String avatarUrl, String intro, int imgHeight) {
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.intro = intro;
        this.imgHeight = imgHeight;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public String getIntro() {
        return intro;
    }


}
