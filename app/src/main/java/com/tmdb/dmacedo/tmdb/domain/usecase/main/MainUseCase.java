package com.tmdb.dmacedo.tmdb.domain.usecase.main;

import com.tmdb.dmacedo.tmdb.data.repository.main.RemoteMainRepository;
import com.tmdb.dmacedo.tmdb.domain.usecase.UseCase;
import com.tmdb.dmacedo.tmdb.entity.PopularMovies;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MainUseCase extends UseCase<List<PopularMovies>> {

    private RemoteMainRepository repository;


    @Inject
    public MainUseCase(RemoteMainRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Observable<List<PopularMovies>> createObservable() {
        return repository.popularMovies();
    }
}
