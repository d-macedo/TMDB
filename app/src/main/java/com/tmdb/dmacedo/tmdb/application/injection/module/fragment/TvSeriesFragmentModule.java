package com.tmdb.dmacedo.tmdb.application.injection.module.fragment;

import android.arch.lifecycle.ViewModelProviders;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.TvFragment;
import com.tmdb.dmacedo.tmdb.domain.usecase.main.TvSeriesUseCase;
import com.tmdb.dmacedo.tmdb.infrastructure.di.SchedulerProvider;
import com.tmdb.dmacedo.tmdb.presentation.viewmodel.main.TvSeriesFragmentViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class TvSeriesFragmentModule {

    @Provides
    static TvSeriesFragmentViewModel provideTvSeriesFragmentViewModel(
            TvFragment tvFragment,
            TvSeriesUseCase useCase,
            SchedulerProvider provider
    ) {
        TvSeriesFragmentViewModel viewModel = ViewModelProviders.of(tvFragment).get(TvSeriesFragmentViewModel.class);
        viewModel.setUseCase(useCase);
        viewModel.setProvider(provider);
        return viewModel;
    }
}
