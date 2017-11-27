package com.tmdb.dmacedo.tmdb.application;

import android.app.Activity;
import android.app.Application;


import com.tmdb.dmacedo.tmdb.application.injection.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class TmdbApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> injector;


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
}
