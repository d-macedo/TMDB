package com.tmdb.dmacedo.tmdb.data.repository.main;


import com.tmdb.dmacedo.tmdb.data.mapper.MainMapper;
import com.tmdb.dmacedo.tmdb.data.mapper.TvSeriesMapper;
import com.tmdb.dmacedo.tmdb.data.webservice.TmdbWebService;
import com.tmdb.dmacedo.tmdb.data.webservice.TmdbWebServiceFactory;
import com.tmdb.dmacedo.tmdb.entity.PopularMovies;
import com.tmdb.dmacedo.tmdb.entity.TvSeries;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RemoteMainRepository implements MainRepository{

    private TmdbWebService service;

    @Inject
    public RemoteMainRepository(TmdbWebService service) {
        this.service = service;
    }

    @Override
    public Observable<List<PopularMovies>> popularMovies() {
        return service.getPopularMovies()
                .map(MainMapper::transform)
                .toObservable();
    }

    @Override
    public Observable<List<TvSeries>> tvSeries() {
        return service.getTvSeries()
                .map(TvSeriesMapper::transform)
                .toObservable();
    }
}
