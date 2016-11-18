package com.example.hoang.myapplication.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.adapter.ViewPagerAccountAdapter;
import com.example.hoang.myapplication.helper.Helper;

import butterknife.ButterKnife;

public class AccountActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAccountAdapter mViewPagerAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        findView();
        setUpTablayout();
        setUpToolbar();

    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Account Activity");
//        getSupportActionBar().

    }

    private void findView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
    }


    private void setUpTablayout() {
        mViewPagerAdapter = new ViewPagerAccountAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_restaurant_menu_white_24px);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_more_vert_white_24dp);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
            return super.onOptionsItemSelected(item);
    }

}
