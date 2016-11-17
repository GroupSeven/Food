package com.example.hoang.myapplication.model;

/**
 * Created by hoang on 11/18/16.
 */

public class Timeline {
    private String name;
    private String content;
    private String imgUrl;
    private String time;

    public Timeline(String name, String content, String imgUrl, String time) {
        this.name = name;
        this.content = content;
        this.imgUrl = imgUrl;
        this.time = time;
    }

    public Timeline() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
