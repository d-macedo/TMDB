package com.tmdb.dmacedo.tmdb.domain.usecase.main;

import com.tmdb.dmacedo.tmdb.data.repository.main.RemoteMainRepository;
import com.tmdb.dmacedo.tmdb.domain.usecase.UseCase;
import com.tmdb.dmacedo.tmdb.entity.TvSeries;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;

public class TvSeriesUseCase extends UseCase<List<TvSeries>> {

    private RemoteMainRepository repository;

    @Inject
    public TvSeriesUseCase(RemoteMainRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Observable<List<TvSeries>> createObservable() {
        return repository.tvSeries();
    }
}
