package com.example.hoang.myapplication.activity.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.adapter.FoodAdapter;
import com.example.hoang.myapplication.helper.DataFood;

import butterknife.ButterKnife;

/**
 * Created by hoang on 11/12/16.
 */

public class FragmentFood extends Fragment {
    private RecyclerView recyclerViewFood;
    private FoodAdapter foodAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_layout, container, false);
        ButterKnife.bind(this, view);
        recyclerViewFood = (RecyclerView) view.findViewById(R.id.rcFood);
        foodAdapter = new FoodAdapter(getContext(), DataFood.posts());
        recyclerViewFood.setAdapter(foodAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        recyclerViewFood.setLayoutManager(linearLayoutManager);
        return view;
    }
}



/////////////////




//package com.example.hoang.myapplication.activity.home.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.hoang.myapplication.R;
//import com.example.hoang.myapplication.adapter.FoodAdapter;
//import com.example.hoang.myapplication.helper.DataFood;
//import com.example.hoang.myapplication.model.Food;
//
//import java.util.ArrayList;
//
//import butterknife.ButterKnife;
//
///**
// * Created by hoang on 11/12/16.
// */
//
//public class FragmentFood extends Fragment {
//    private ArrayList<Food> myObjectArrayList;
//    private RecyclerView recyclerViewFood;
//    private FoodAdapter foodAdapter;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_food_layout, container, false);
//        ButterKnife.bind(this, view);
//        recyclerViewFood = (RecyclerView) view.findViewById(R.id.rcFood);
//
//        myObjectArrayList =  new ArrayList<>();
//        for (int i = 0; i < 20; i++){
//            myObjectArrayList.add(new Food(
//                    "Bakery " + i,
//                    "Quan " + i,
//                    "https://unsplash.it/200/200/?image=" + i,
////                    "https://unsplash.it/200/200?image=" + i,
//                    "officia porro iure quia iusto qui ipsa ut modi"  + i
//            ));
//        }
//        foodAdapter = new FoodAdapter(getContext(), DataFood.posts());
//        recyclerViewFood.setAdapter(foodAdapter);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
//        recyclerViewFood.setLayoutManager(linearLayoutManager);
//        return view;
//    }
//}
