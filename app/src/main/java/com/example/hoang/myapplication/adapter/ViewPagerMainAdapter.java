package com.example.hoang.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hoang.myapplication.fragment.FragmentFood;
import com.example.hoang.myapplication.fragment.FragmentMapNearly;
import com.example.hoang.myapplication.fragment.FragmentProfile;
import com.example.hoang.myapplication.fragment.FragmentStoreList;
import com.example.hoang.myapplication.fragment.FragmentTimeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoang on 11/12/16.
 */

public class ViewPagerMainAdapter extends FragmentPagerAdapter {
    private  List<Fragment> fragmentList;
    private  List<String> fragmentTitleList;

    public ViewPagerMainAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentTimeline());
        fragmentList.add(new FragmentFood());
        fragmentList.add(new FragmentStoreList());
        fragmentList.add(new FragmentMapNearly());
        fragmentList.add(new FragmentProfile());

        fragmentTitleList = new ArrayList<>();
        fragmentTitleList.add("What's News");
        fragmentTitleList.add("Food");
        fragmentTitleList.add("Store");
        fragmentTitleList.add("Near me");
        fragmentTitleList.add("Profile");
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
