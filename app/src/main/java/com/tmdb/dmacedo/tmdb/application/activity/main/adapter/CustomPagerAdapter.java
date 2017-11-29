package com.tmdb.dmacedo.tmdb.application.activity.main.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.MovieFragment;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.OtherFragment;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.TvFragment;

/**
 * Created by Daniel on 28/11/2017.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;

    public CustomPagerAdapter(FragmentManager manager, int NumOfTabs){
        super(manager);
        this.numOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TvFragment tab1 = new TvFragment();
                return tab1;
            case 1:
                MovieFragment tab2 = new MovieFragment();
                return tab2;
            case 2:
                OtherFragment tab3 = new OtherFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
