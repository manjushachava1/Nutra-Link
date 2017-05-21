package com.example.manjushachava.foodapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class SectionsPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    /**
     * Adds a fragment and sets the name of the fragment tab
     * @param fragment the fragment tab
     * @param title the name of the title of the tab
     */
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    /**
     * Manages all of the fragments
     * @param fm manages the fragments
     */
    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * @param position the position
     * @return the char at a position of the fragment title list
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    /**
     * @param position the position
     * @return the fragment at the position of the fragment list
     *
     */
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    /**
     * @return the size of the fragment list
     */
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}