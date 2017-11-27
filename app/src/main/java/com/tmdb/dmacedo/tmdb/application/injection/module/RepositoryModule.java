package com.tmdb.dmacedo.tmdb.application.injection.module;


import com.tmdb.dmacedo.tmdb.data.repository.main.MainRepository;
import com.tmdb.dmacedo.tmdb.data.repository.main.RemoteMainRepository;
import com.tmdb.dmacedo.tmdb.data.webservice.TmdbWebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    static MainRepository providesMainRepository (TmdbWebService service){
        return new RemoteMainRepository(service);
    }
}
