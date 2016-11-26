package com.example.hoang.myapplication.maps;

import java.util.List;

/**
 * Created by hoang on 2016/11/26.
 */
public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
