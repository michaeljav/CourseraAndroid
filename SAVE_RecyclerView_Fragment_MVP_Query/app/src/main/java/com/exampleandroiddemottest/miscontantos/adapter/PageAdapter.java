package com.exampleandroiddemottest.miscontantos.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> framents;

    public PageAdapter(FragmentManager fm,ArrayList<Fragment> fragments) {

        super(fm);
        this.framents = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return framents.get(i);
    }

    @Override
    public int getCount() {
        return framents.size();
    }
}
