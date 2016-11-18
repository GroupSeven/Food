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
 * Created by hoang on 18/11/2016.
 */

public class Fragment_Account_Login extends Fragment{
    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login_layout, container, false);
        ButterKnife.bind(this, view);


        return view;
    }
}
