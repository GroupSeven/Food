package com.example.hoang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hoang.myapplication.R;
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

public class Fragment_Account_Register extends Fragment {
    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.edtPassword)
    EditText edtPassword;
    @BindView(R.id.edtPassword2)
    EditText edtPassword2;
    @BindView(R.id.btnReg)
    Button btnReg;

    TextView textView;
;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    LinearLayout r;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register_layout, container, false);
        ButterKnife.bind(this, view);

        mAuth = FirebaseAuth.getInstance();
        r = (LinearLayout) view.findViewById(R.id.reg_content);
        textView = (TextView) view.findViewById(R.id.tvOK);

        register();
        return view;
    }

    private void register() {
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = validateForm();
                if (isValid) {
                    sigUp(edtUser.getText().toString().trim(), edtPassword.getText().toString().trim());
                } else {
                    Helper.showMsg(getContext(), "You must put mail, pass corectly or not null");
                }
            }


        });
    }

    private void sigUp(String e, String p) {
        mAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    r.setVisibility(View.GONE);
                    textView.setText(task.getResult().getUser().getEmail() + " \n Registration was successful \n Swipe left to login :)");
                    textView.setTextSize(20f);
                    textView.setVisibility(View.VISIBLE);
//                    tvOK.setVisibility(View.VISIBLE);
                }
                if (!task.isSuccessful()) {
                    Helper.showMsg(getContext(), task.getException().getLocalizedMessage());

                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private boolean validateForm() {
        if ( edtUser.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()
                ) {
            return false;
        } else {
            return true;
        }
    }

}
