package com.tmdb.dmacedo.tmdb.presentation.viewmodel.main;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.tmdb.dmacedo.tmdb.domain.usecase.main.MainUseCase;
import com.tmdb.dmacedo.tmdb.entity.PopularMovies;
import com.tmdb.dmacedo.tmdb.infrastructure.di.SchedulerProvider;
import com.tmdb.dmacedo.tmdb.presentation.model.ResourceModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MovieFragmentViewModel extends ViewModel {

    private MutableLiveData<ResourceModel<List<PopularMovies>>> movies;

    private MainUseCase useCase;


    @Inject
    protected SchedulerProvider provider;

    private CompositeDisposable disposable = new CompositeDisposable();


    public void setProvider(SchedulerProvider provider) {
        this.provider = provider;
    }

    public void setUseCase(MainUseCase useCase) {
        this.useCase = useCase;
    }

    public LiveData<ResourceModel<List<PopularMovies>>> loadMovies(){
        if (movies == null) {
            movies = new MutableLiveData<>();
            movies.postValue(new ResourceModel<>(ResourceModel.State.LOADING, null, null));
            useCase.execute(
                    Schedulers.computation(),
                    AndroidSchedulers.mainThread(),
                    new PoupularMoviesFragmentObserver()
            );
        }
        return movies;
    }

    public class PoupularMoviesFragmentObserver implements Observer<List<PopularMovies>> {

        @Override
        public void onSubscribe(Disposable d) {
            disposable.add(d);
        }

        @Override
        public void onNext(List<PopularMovies> popularMovies) {
            movies.postValue(new ResourceModel<>(
                    ResourceModel.State.SUCCESS,
                    popularMovies,
                    null
            ));
        }

        @Override
        public void onError(Throwable e) {
            movies.postValue(new ResourceModel<>(
                    ResourceModel.State.ERROR,
                    null,
                    e.getMessage()
            ));
        }

        @Override
        public void onComplete() {
            // do nothing
        }
    }
}
