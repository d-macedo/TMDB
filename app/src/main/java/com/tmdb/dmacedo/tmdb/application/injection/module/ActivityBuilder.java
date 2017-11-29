package com.tmdb.dmacedo.tmdb.application.injection.module;

import com.tmdb.dmacedo.tmdb.application.activity.main.MainActivity;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.MovieFragment;
import com.tmdb.dmacedo.tmdb.application.injection.module.activity.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity provideMainActivity();

}
