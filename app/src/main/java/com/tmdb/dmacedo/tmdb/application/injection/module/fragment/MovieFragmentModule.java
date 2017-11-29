package com.tmdb.dmacedo.tmdb.application.injection.module.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.MovieFragment;
import com.tmdb.dmacedo.tmdb.domain.usecase.main.MainUseCase;
import com.tmdb.dmacedo.tmdb.infrastructure.di.SchedulerProvider;
import com.tmdb.dmacedo.tmdb.presentation.viewmodel.main.MovieFragmentViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniel on 28/11/2017.
 */

@Module
public class MovieFragmentModule {

    @Provides
    static MovieFragmentViewModel providesMovieFragmentViewModel(
            MovieFragment movieFragment,
            MainUseCase useCase,
            SchedulerProvider provider
            ){
        MovieFragmentViewModel viewModel = ViewModelProviders.of(movieFragment).get(MovieFragmentViewModel.class);
        viewModel.setUseCase(useCase);
        viewModel.setProvider(provider);
        return viewModel;
    }

}
