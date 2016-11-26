package com.example.hoang.myapplication.maps;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by hoang on 2016/11/26.
 */

public class Route {
    public com.example.hoang.myapplication.maps.Distance distance;
    public Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;

    public List<LatLng> points;
}
