package com.example.hoang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.helper.Helper;

public class ProfileActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "cheese_name";
    private static final String PROFILE_URL = "http://img.f26.kinhdoanh.vnecdn.net/2016/11/24/diengiaVEPR201635201479952510-3401-2605-1479966259_490x294.jpg";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        final String cheeseName = intent.getStringExtra(EXTRA_NAME);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(cheeseName);

        loadBackdrop();
    }
//
    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(PROFILE_URL).centerCrop().into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_profile, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnClick(View view) {
        Helper.showMsg(getApplicationContext(),"btn");
    }
}
