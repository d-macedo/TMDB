package com.tmdb.dmacedo.tmdb.application.injection.module;


import com.tmdb.dmacedo.tmdb.infrastructure.di.DefaultSchedulerProvider;
import com.tmdb.dmacedo.tmdb.infrastructure.di.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InfrastructureModule {

    @Provides
    @Singleton
    static SchedulerProvider providesSchedulerProvider(){
        return new DefaultSchedulerProvider();
    }
}
