package com.example.hoang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.helper.Helper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hoang on 18/11/2016.
 */

public class Fragment_Account_Login extends Fragment {
    private View view;
    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvFogot)
    TextView tvFogot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login_layout, container, false);
        ButterKnife.bind(this, view);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper.showMsg(getContext(), "what do you do with this function :v");
            }
        });

        tvFogot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do sth
                Helper.showMsg(getContext(), "what do you do with this function :v");

            }
        });


        return view;

    }
}
