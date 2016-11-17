package com.example.hoang.myapplication.helper;

import android.util.Log;

import com.example.hoang.myapplication.model.Food;
import com.example.hoang.myapplication.model.StoreUser;
import com.example.hoang.myapplication.model.Timeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoang on 11/14/16.
 */

public class Data {

    public static List<Food> posts() {
        List<Food> post = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                Log.d("KIEMTRA", String.valueOf(i));
                int x = 0;
                x = i * 10 + j;
                post.add(new Food(
                        "Soda " + x,
                        "District " + j,
                        "http://lorempixel.com/400/400/food/" + j,
                        "officia porro iure quia iusto qui ipsa ut modi" + j
                ));
            }
        }
        return post;
    }

    public static List<StoreUser> postsStoreList() {
        List<StoreUser> postsStoreList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                int x = 0;
                x = i * 10 + j;
                postsStoreList.add(new StoreUser(
                        "Store: " + x,
                        "District " + j,
                        "kaka" + j
                ));
            }
        }
        return postsStoreList;
    }
    public static List<Timeline> postingTimelineList() {
        List<Timeline> postingTimelineList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                int x = 0;
                x = i * 10 + j;
                postingTimelineList.add(new Timeline(
                        "Name: " + x,
                        "Lorem Ipsum is simply dummy text of the printing and typesetti" +
                                "ng industry. Lorem Ipsu" +
                                "m has been the industry's standard dummy text ever since the 1500s, " + j,
                        "http://lorempixel.com/400/400/food/" + j,
                        "Time " + x
                ));
            }
        }
        return postingTimelineList;
    }

}
