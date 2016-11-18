package com.example.hoang.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hoang.myapplication.fragment.Fragment_Account_Login;
import com.example.hoang.myapplication.fragment.Fragment_Account_Register;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoang on 18/11/2016.
 */

public class ViewPagerAccountAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    private  List<String> fragmentTitleList;

    public ViewPagerAccountAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_Account_Login());
        fragmentList.add(new Fragment_Account_Register());

        fragmentTitleList = new ArrayList<>();
        fragmentTitleList.add("Login");
        fragmentTitleList.add("Register");
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
