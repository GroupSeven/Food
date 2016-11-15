package com.example.hoang.myapplication.model;

/**
 * Created by hoang on 11/14/16.
 */

public class StoreUser {
    private String name;
    private String phone;
//    private String lat;
//    private String lng;
    private String locate;

    public StoreUser() {
    }

    public StoreUser(String name, String phone, String locate) {
        this.name = name;
        this.phone = phone;
        this.locate = locate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }
}
