package com.tmdb.dmacedo.tmdb.data.repository.main;


import com.tmdb.dmacedo.tmdb.entity.PopularMovies;
import com.tmdb.dmacedo.tmdb.entity.TvSeries;

import java.util.List;

import io.reactivex.Observable;

public interface MainRepository {

    Observable<List<PopularMovies>> popularMovies();

    Observable<List<TvSeries>> tvSeries();
}
