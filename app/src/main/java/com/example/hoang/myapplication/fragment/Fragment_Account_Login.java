package com.example.hoang.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.activity.MainActivity;
import com.example.hoang.myapplication.helper.Helper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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


    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login_layout, container, false);
        ButterKnife.bind(this, view);
        mAuth = FirebaseAuth.getInstance();

        signIn();

        return view;

    }

    private void signIn() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean iValid = validateForm();
                if (iValid) {
                    register(edtUser.getText().toString().trim(), edtPassword.getText().toString().trim());
                } else {
                    Helper.showMsg(getContext(), "check input");

                }
            }
        });
    }

    private void register(String e, String p) {
        mAuth.signInWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Helper.showMsg(getContext(), "Loged");
                    startActivity(new Intent(getContext(), MainActivity.class));
                } else {
                    Helper.showMsg(getContext(), task.getException().getLocalizedMessage());
                }
            }
        });
    }

    private boolean validateForm() {
        if (edtUser.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()
                ) {
            return false;
        } else {
            return true;
        }
    }
}
