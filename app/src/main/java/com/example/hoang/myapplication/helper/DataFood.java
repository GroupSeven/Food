package com.example.hoang.myapplication.helper;

import com.example.hoang.myapplication.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoang on 11/14/16.
 */

public class DataFood {

    public static List<Food> posts() {
        String des = "A drawable resource is a general concept for a graphic that can be drawn to the screen." +
                " Drawables are used to define shapes, colors, borders, gradients, etc. " +
                "which can then be applied to views within an Activity.";
        List<Food> post = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            post.add(new Food(
                    "Soda " + i,
                    "Quan " + i,
                    "https://unsplash.it/200/200/?image=" + i,
                    "officia porro iure quia iusto qui ipsa ut modi"  + i
            ));
        }
        return post;
    }
}
