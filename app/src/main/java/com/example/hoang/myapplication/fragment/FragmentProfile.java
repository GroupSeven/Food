package com.example.hoang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoang.myapplication.R;

import butterknife.ButterKnife;

/**
 * Created by hoang on 11/23/16.
 */

public class FragmentProfile extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile_layout, container, false);
        ButterKnife.bind(this, view);


        return view;
    }
}
