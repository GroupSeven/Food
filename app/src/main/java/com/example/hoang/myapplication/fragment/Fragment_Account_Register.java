package com.example.hoang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.helper.Helper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hoang on 18/11/2016.
 */

public class Fragment_Account_Register extends Fragment{
    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnReg)
    Button btnReg;

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register_layout, container, false);
        ButterKnife.bind(this, view);
    btnReg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Helper.showMsg(getContext(),"Binding OK");
        }
    });

        return view;
    }
}
