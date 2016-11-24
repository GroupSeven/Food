package com.example.hoang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.hoang.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostSnippetActivity extends AppCompatActivity {
    @BindView(R.id.edt)
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_snippet);
        ButterKnife.bind(this);

        Intent iPut = new Intent(getApplicationContext(), PostSnippetActivity.class);
        Intent iGet = getIntent();
        edt.setText(iGet.getStringExtra("snippet").toString());

        iPut.putExtra("snippet", edt.getText().toString());
        startActivity(iPut);
    }

    public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), PostActivity.class));
    }

}
