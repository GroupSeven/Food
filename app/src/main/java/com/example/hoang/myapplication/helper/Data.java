package com.example.hoang.myapplication.helper;

import com.example.hoang.myapplication.model.Food;
import com.example.hoang.myapplication.model.StoreUser;
import com.example.hoang.myapplication.model.Timeline;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by hoang on 11/14/16.
 */

public class Data {


    public static List<Food> posts() {
        List<Food> post = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
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


        final String[] nameStringList = {"Chester Flagg", "Gladis Melillo ",
                "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Dayle Almeda", "Lynsey Murdoch", "Shin Zuccaro",
                "Betsey Deal", "Inez Darrigo", "\"Bonny Barnette\", \n", "Amber Kingery", "Marx Charney", "Chester Flagg", "Desmond Rezendes",
                "Malcolm Bradwell ", "Amber Kingery", "Marcia Baynard", "Phoebe Kimbell", "Harley Vancil", "Eilene Kivi", "Kaycee Ying",
                "Geraldo Erby", "Gladis Melillo", "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Obdulia Fredricks", "Betsey Deal",
                "Inez Darrigo", "Bonny Barnette", "abc", "123", "Chester Flagg", "Gladis Melillo ",
                "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Dayle Almeda", "Lynsey Murdoch", "Shin Zuccaro",
                "Betsey Deal", "Inez Darrigo", "\"Bonny Barnette\", \n", "Amber Kingery", "Marx Charney", "Chester Flagg", "Desmond Rezendes",
                "Malcolm Bradwell ", "Amber Kingery", "Marcia Baynard", "Phoebe Kimbell", "Harley Vancil", "Eilene Kivi", "Kaycee Ying",
                "Geraldo Erby", "Gladis Melillo", "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Obdulia Fredricks", "Betsey Deal",
                "Inez Darrigo", "Bonny Barnette", "abc", "123", "Chester Flagg", "Gladis Melillo ",
                "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Dayle Almeda", "Lynsey Murdoch", "Shin Zuccaro",
                "Betsey Deal", "Inez Darrigo", "\"Bonny Barnette\", \n", "Amber Kingery", "Marx Charney", "Chester Flagg", "Desmond Rezendes",
                "Malcolm Bradwell ", "Amber Kingery", "Marcia Baynard", "Phoebe Kimbell", "Harley Vancil", "Eilene Kivi", "Kaycee Ying",
                "Geraldo Erby", "Gladis Melillo", "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Obdulia Fredricks", "Betsey Deal",
                "Inez Darrigo", "Bonny Barnette", "abc", "123", "Chester Flagg", "Gladis Melillo ",
                "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Dayle Almeda", "Lynsey Murdoch", "Shin Zuccaro",
                "Betsey Deal", "Inez Darrigo", "\"Bonny Barnette\", \n", "Amber Kingery", "Marx Charney", "Chester Flagg", "Desmond Rezendes",
                "Malcolm Bradwell ", "Amber Kingery", "Marcia Baynard", "Phoebe Kimbell", "Harley Vancil", "Eilene Kivi", "Kaycee Ying",
                "Geraldo Erby", "Gladis Melillo", "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Obdulia Fredricks", "Betsey Deal",
                "Inez Darrigo", "Bonny Barnette", "abc", "123", "Chester Flagg", "Gladis Melillo ",
                "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Dayle Almeda", "Lynsey Murdoch", "Shin Zuccaro",
                "Betsey Deal", "Inez Darrigo", "\"Bonny Barnette\", \n", "Amber Kingery", "Marx Charney", "Chester Flagg", "Desmond Rezendes",
                "Malcolm Bradwell ", "Amber Kingery", "Marcia Baynard", "Phoebe Kimbell", "Harley Vancil", "Eilene Kivi", "Kaycee Ying",
                "Geraldo Erby", "Gladis Melillo", "Dayle Almeda", "Shin Zuccaro", "Lynsey Murdoch", "Obdulia Fredricks", "Betsey Deal",
                "Inez Darrigo", "Bonny Barnette"
        };


        List<Timeline> postingTimelineList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                int x = 0;
                x = i * 10 + j;
                postingTimelineList.add(new Timeline(
                        nameStringList[x].toString(),
                        "Lorem Ipsum is simply dummy text of the printing and typesetti" +
                                "ng industry. Lorem Ipsu" +
                                "m has been the industry's standard dummy text ever since the 1500s, " + j,
                        "http://lorempixel.com/400/400/food/" + j,
                        "Time " + x,
                        "http://lorempixel.com/400/400/people/" + j
                ));
            }
        }
        return postingTimelineList;
    }

    public static List<StoreUser> postLatLngStoreUser() {
        List<StoreUser> mList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String lat, lng;
                lat = "10." + i + j + "84792";
                lng = "106." + j + i + "0996";
                mList.add(new StoreUser(Float.parseFloat(lat), Float.parseFloat(lng)));
            }

        }

        return mList;
    }


    public static List<StoreUser> UserFulldetail() {

        List<StoreUser> mList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String lat, lng;
                lat = "10." + i + j + "84792";
                lng = "106." + j + i + "0996";
                mList.add(new StoreUser("Cua hang  " + i + j, "098765432", Float.parseFloat(lat), Float.parseFloat(lng), " Quan " + j));
            }

        }

        return mList;
    }

    public static LatLng latLngHCM() {
        return new LatLng(10.829457, 106.682206);

    }

    public static LatLng latLngHCM2() {
        return new LatLng(10.822012, 106.687146);

    }


}
