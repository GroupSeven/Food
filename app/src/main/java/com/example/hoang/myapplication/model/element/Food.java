package com.example.hoang.myapplication.model.element;

/**
 * Created by hoang on 11/13/16.
 */

public class Food {
    private String name;
    private String locate;
    private String imgUrl;
    private String snippet;

    public Food(String name, String locate, String imgUrl, String snippet) {
        this.name = name;
        this.locate = locate;
        this.imgUrl = imgUrl;
        this.snippet = snippet;
    }

    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
