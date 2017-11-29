package com.tmdb.dmacedo.tmdb.application;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;


import com.tmdb.dmacedo.tmdb.application.injection.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class TmdbApplication extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> injector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        buildTopLevelDependenciesGraph();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return injector;
    }


    protected void buildTopLevelDependenciesGraph(){
        DaggerAppComponent.builder().application(this).build().inject(this);
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragInjector;
    }
}
