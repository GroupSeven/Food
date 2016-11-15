package com.example.hoang.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hoang.myapplication.activity.home.fragment.FragmentFood;
import com.example.hoang.myapplication.activity.home.fragment.FragmentTimeline;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoang on 11/12/16.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private  List<Fragment> fragmentList;
    private  List<String> fragmentTitleList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentFood());
        fragmentList.add(new FragmentTimeline());
//        fragmentList.add(new FragmentSomething());
//        fragmentList.add(new FragmentComplain());

        fragmentTitleList = new ArrayList<>();
//        fragmentTitleList.add("FragmentFood");
//        fragmentTitleList.add("timeline");
//        fragmentTitleList.add("FragmentSomething");
//        fragmentTitleList.add("FragmentComplain");
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return fragmentTitleList.get(position);
//    }
}
