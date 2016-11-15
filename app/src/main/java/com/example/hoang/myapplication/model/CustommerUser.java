package com.example.hoang.myapplication.model;

/**
 * Created by hoang on 11/14/16.
 */

public class CustommerUser {
    private String name;
    private String phone;
    private float lat;
    private float lng;

    public CustommerUser(String name, String phone, float lat, float lng) {
        this.name = name;
        this.phone = phone;
        this.lat = lat;
        this.lng = lng;
    }

    public CustommerUser() {
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

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
