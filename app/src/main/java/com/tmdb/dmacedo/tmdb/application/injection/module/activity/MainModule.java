package com.tmdb.dmacedo.tmdb.application.injection.module.activity;


import android.arch.lifecycle.ViewModelProviders;
import com.tmdb.dmacedo.tmdb.application.activity.main.MainActivity;
import com.tmdb.dmacedo.tmdb.application.activity.main.fragments.MovieFragment;
import com.tmdb.dmacedo.tmdb.domain.usecase.main.MainUseCase;
import com.tmdb.dmacedo.tmdb.infrastructure.di.SchedulerProvider;
import com.tmdb.dmacedo.tmdb.presentation.viewmodel.main.MainViewModel;
import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    static MainViewModel providesMainViewModel(
            MainActivity mainActivity ,
            MainUseCase useCase,
            SchedulerProvider scheduler) {
        MainViewModel viewModel = ViewModelProviders.of(mainActivity).get(MainViewModel.class);
        viewModel.setUseCase(useCase);
        viewModel.setProvider(scheduler);
        return viewModel;
    }
}
