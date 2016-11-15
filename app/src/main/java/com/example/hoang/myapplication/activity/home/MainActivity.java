package com.example.hoang.myapplication.activity.home;

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
import android.widget.Toast;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.activity.LoginActivity;
import com.example.hoang.myapplication.activity.MapsActivity;
import com.example.hoang.myapplication.adapter.ViewPagerAdapter;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;


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
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
            tabLayout.getTabAt(0).setIcon(R.drawable.ic_restaurant_menu_black_24px);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_apps_black_24dp);
//            tabLayout.getTabAt(2).setIcon(R.drawable.ic_favorite_black_24dp);
//            tabLayout.getTabAt(3).setIcon(R.drawable.ic_event_note_black_24dp);

    }

    private void setUpDrawer() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.open);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        // icon toogle
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

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
            case R.id.itHelp :
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                myToast("itHelp");
                break;
            case R.id.itLogin :
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                myToast("login");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void myToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
