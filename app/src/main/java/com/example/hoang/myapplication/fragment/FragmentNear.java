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
import com.example.hoang.myapplication.adapter.ListStoreAdapter;
import com.example.hoang.myapplication.helper.Data;

import butterknife.ButterKnife;

/**
 * Created by hoang on 11/12/16.
 */

public class FragmentNear extends Fragment {
    private RecyclerView recyclerViewListUser;
    private ListStoreAdapter foodAdapter;
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timeline_layout, container, false);
        ButterKnife.bind(this, view);

        setUpRecycler();

        return view;
    }

    private void setUpRecycler() {
        recyclerViewListUser = (RecyclerView) view.findViewById(R.id.rcListStore);
        foodAdapter = new ListStoreAdapter(getContext(), Data.postsStoreList());
        recyclerViewListUser.setAdapter(foodAdapter);
        recyclerViewListUser.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL,false));
    }
}
