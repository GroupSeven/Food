package com.example.hoang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hoang.myapplication.R;

public class FoodDetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "cheese_name";
    private String fName = "failed";
    private String imgurl = "http://successhacker.org/wp-content/uploads/2014/05/Failed-580x390-300x201.jpg";
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();


        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        collapsingToolbar.setTitle(i.getStringExtra("foodName"));
        loadBackdrop(i.getStringExtra("imgurl"));
    }

    private void loadBackdrop(String url) {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(url).centerCrop().placeholder(R.drawable.pladeholder).into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_store, menu);
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

}
