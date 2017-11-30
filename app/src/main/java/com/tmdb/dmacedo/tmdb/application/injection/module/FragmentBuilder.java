package com.tmdb.dmacedo.tmdb.application.injection.module;

import android.support.transition.Transition;

import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.MovieFragment;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.TvFragment;
import com.tmdb.dmacedo.tmdb.application.injection.module.fragment.MovieFragmentModule;
import com.tmdb.dmacedo.tmdb.application.injection.module.fragment.TvSeriesFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Daniel on 29/11/2017.
 */

@Module
public abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = {MovieFragmentModule.class})
    abstract MovieFragment providesMovieFragmentViewModel();

    @ContributesAndroidInjector(modules = {TvSeriesFragmentModule.class})
    abstract TvFragment provideTvSeriesFragmentViewModel();
}
