package com.example.hoang.myapplication.model;

/**
 * Created by hoang on 11/14/16.
 */

public class StoreUser {
    private String name;
    private String phone;
    private double lat;
    private double lng;
    private String locate;

    public StoreUser() {
    }

    public StoreUser(String name, String phone, String locate) {
        this.name = name;
        this.phone = phone;
        this.locate = locate;
    }

    public StoreUser(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public StoreUser(String name, String phone, double lat, double lng, String locate) {
        this.name = name;
        this.phone = phone;
        this.lat = lat;
        this.lng = lng;
        this.locate = locate;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
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
