package com.example.hoang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.hoang.myapplication.R;
import com.example.hoang.myapplication.adapter.ViewPagerMainAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerMainAdapter mViewPagerAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    CoordinatorLayout coordinatorLayout;
    FirebaseUser user;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            Toast.makeText(getApplicationContext(), user.getEmail(), Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "chuwa dang nhap", Toast.LENGTH_SHORT).show();
        }

        findView();
        setupToolbar();
        setUpDrawer();
        setUpTablayout();
    }

    private void setUpTablayout() {
        mViewPagerAdapter = new ViewPagerMainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mViewPagerAdapter);
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
//        setIconTab(); //// unComment to add Icon


    }

    private void setIconTab() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_restaurant_menu_white_24px);
        tabLayout.getTabAt(1).setIcon(R.drawable.quantum_ic_closed_caption_white_36);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_palette_white_24px);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_explore_white_24px);
    }

    private void setUpDrawer() {
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.open);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.syncState();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("main title");

    }

    private void findView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_main, menu);
        if (user != null) {
            menu.findItem(R.id.itAccount).setVisible(false);
            menu.findItem(R.id.itLogout).setVisible(true);
            menu.findItem(R.id.itPost).setVisible(true);
        }
        if (user == null) {
            menu.findItem(R.id.itProfile).setVisible(false);
            menu.findItem(R.id.itLogout).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.itCart:
//                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Welcome to AndroidHive", Snackbar.LENGTH_LONG);
                snackbar.show();
                myToast("itCart");
                break;
            case R.id.itPost:
                startActivity(new Intent(getApplicationContext(), PostActivity.class));
                break;
            case R.id.itLoli:
                startActivity(new Intent(getApplicationContext(), TclassActivity.class));
                break;
            case R.id.itProfile:
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                break;
            case R.id.itAccount:
                startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                break;
            case R.id.itLogout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
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
