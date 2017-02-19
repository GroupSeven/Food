package com.example.hoang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.adapter.TimelineAdapter;
import com.example.hoang.myapplication.helper.Data;

import butterknife.ButterKnife;

/**
 * Created by hoang on 11/12/16.
 */

public class FragmentTimeline extends Fragment {
    private View view, view2;
    private Snackbar snackbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout_timeline, container, false);

        setUpRecycler();
        return view;
    }


    private void setUpRecycler() {
        RecyclerView recyclerViewFood = (RecyclerView) view.findViewById(R.id.rvTimeline);
        TimelineAdapter foodAdapter = new TimelineAdapter(getContext(), Data.postingTimelineList());
        recyclerViewFood.setAdapter(foodAdapter);
        recyclerViewFood.setLayoutManager(new GridLayoutManager(getContext(), 1, LinearLayoutManager.VERTICAL, false));
    }
}