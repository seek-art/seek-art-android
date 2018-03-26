package com.android.xunyi.Entity;

/**
 * Created by zsd19 on 2018/3/26.
 */

public class Template {
    private int id;
    private String title;
    private int avatarId;
    private String intro;

    public Template(int id, String title, int avatarId, String intro) {
        this.id = id;
        this.title = title;
        this.avatarId = avatarId;
        this.intro = intro;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public String getIntro() {
        return intro;
    }
}
