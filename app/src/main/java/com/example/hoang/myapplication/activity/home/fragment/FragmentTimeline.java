package com.example.hoang.myapplication.activity.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hoang.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hoang on 11/12/16.
 */

public class FragmentTimeline extends Fragment {
    @BindView(R.id.ivTimeline)
    ImageView ivTimeline;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view  = inflater.inflate(R.layout.fragment_timeline_layout,container, false);
        ButterKnife.bind(this, view);
        Glide.with(getContext())
                .load("http://winniekepala.com/wp-content/uploads/What-Is-This-Jackie-Chan.jpg")
                .placeholder(R.drawable.pladeholder)
                .into(ivTimeline);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
