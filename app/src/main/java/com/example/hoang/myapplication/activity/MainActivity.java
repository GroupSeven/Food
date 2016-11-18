package com.example.hoang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.adapter.ViewPagerMainAdapter;
import com.example.hoang.myapplication.helper.Helper;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerMainAdapter mViewPagerAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        findView();
        setupToolbar();
        setUpDrawer();
        setUpTablayout();
    }

    private void setUpTablayout() {
        mViewPagerAdapter = new ViewPagerMainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
            tabLayout.getTabAt(0).setIcon(R.drawable.ic_restaurant_menu_white_24px);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_more_vert_white_24dp);
            tabLayout.getTabAt(2).setIcon(R.drawable.ic_palette_white_24px);
            tabLayout.getTabAt(3).setIcon(R.drawable.ic_explore_white_24px);


    }

    private void setUpDrawer() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.open);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(String.valueOf(tabLayout.getSelectedTabPosition()));

    }

    private void findView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()){
            case R.id.itCart :
                myToast("itCart");
                break;
            case R.id.itnotice:

            case R.id.itHelp :
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                myToast("itHelp");
                break;
            case R.id.itAccount :
                startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                myToast("login");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void myToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        myToast("touched");
        return super.onTouchEvent(event);
    }

}
