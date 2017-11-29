package com.tmdb.dmacedo.tmdb.application.activity.main;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.tmdb.dmacedo.tmdb.R;
import com.tmdb.dmacedo.tmdb.application.activity.detail.DetailActivity;
import com.tmdb.dmacedo.tmdb.application.activity.main.adapter.CustomPagerAdapter;
import com.tmdb.dmacedo.tmdb.application.activity.main.adapter.MainAdapter;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.MovieFragment;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.OtherFragment;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.TvFragment;
import com.tmdb.dmacedo.tmdb.presentation.model.ResourceModel;
import com.tmdb.dmacedo.tmdb.presentation.viewmodel.main.MainViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements TvFragment.OnFragmentInteractionListener, MovieFragment.OnFragmentInteractionListener, OtherFragment.OnFragmentInteractionListener {

    private Toolbar mToolbar;

    private TabLayout mTabLayout;

    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Tv Series"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Popular Movies"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Other Categories"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final CustomPagerAdapter adapter = new CustomPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager = findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
