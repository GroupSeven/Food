package com.example.hoang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.adapter.FoodAdapter;
import com.example.hoang.myapplication.helper.Data;

import butterknife.ButterKnife;

/**
 * Created by hoang on 11/12/16.
 */

public class FragmentFood extends Fragment {
    private RecyclerView recyclerViewFood;
    private FoodAdapter foodAdapter;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_food_layout, container, false);
        ButterKnife.bind(this, view);

        setUpRecycler();

        return view;
    }

    private void setUpRecycler() {
        recyclerViewFood = (RecyclerView) view.findViewById(R.id.rcFood);
        foodAdapter = new FoodAdapter(getContext(), Data.posts());
        recyclerViewFood.setAdapter(foodAdapter);
        recyclerViewFood.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL,false));
    }
}


