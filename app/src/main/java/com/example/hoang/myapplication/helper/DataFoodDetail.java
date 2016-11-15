package com.example.hoang.myapplication.helper;

import android.util.Log;

import com.example.hoang.myapplication.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoang on 11/14/16.
 */

public class DataFoodDetail {

    public static List<Food> posts() {
        String des = "A drawable resource is a general concept for a graphic that can be drawn to the screen." +
                " Drawables are used to define shapes, colors, borders, gradients, etc. " +
                "which can then be applied to views within an Activity.";
        List<Food> post = new ArrayList<>();
//        int x = 1;
//        while (x < 100){
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 10; j++) {
                    Log.d("KIEMTRA", String.valueOf(i));
                    int x = 0;
                    x = i*10 + j;
                    post.add(new Food(
                            "Soda " + x,
                            "District " + j,
                            "http://lorempixel.com/400/400/food/" + j,
                            "officia porro iure quia iusto qui ipsa ut modi" + j
                    ));
                }
            }
//        }


        return post;
    }
}
