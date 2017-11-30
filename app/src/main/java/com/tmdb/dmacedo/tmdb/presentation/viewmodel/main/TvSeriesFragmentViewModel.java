package com.tmdb.dmacedo.tmdb.presentation.viewmodel.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tmdb.dmacedo.tmdb.domain.usecase.main.TvSeriesUseCase;
import com.tmdb.dmacedo.tmdb.entity.TvSeries;
import com.tmdb.dmacedo.tmdb.infrastructure.di.SchedulerProvider;
import com.tmdb.dmacedo.tmdb.presentation.model.ResourceModel;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class TvSeriesFragmentViewModel extends ViewModel {

    private MutableLiveData<ResourceModel<List<TvSeries>>> series;

    private TvSeriesUseCase useCase;

    @Inject
    protected SchedulerProvider provider;

    private CompositeDisposable disposable = new CompositeDisposable();

    public void setUseCase(TvSeriesUseCase useCase) {
        this.useCase = useCase;
    }

    public void setProvider(SchedulerProvider provider) {
        this.provider = provider;
    }

    public LiveData<ResourceModel<List<TvSeries>>> loadSeries() {
        if (series == null) {
            series = new MutableLiveData<>();
            series.postValue(new ResourceModel<>(ResourceModel.State.LOADING, null, null));
            useCase.execute(
                    provider.computation(),
                    provider.main(),
                    new TvSeriesFragmentObserver()
            );
        }
        return series;
    }


    private class TvSeriesFragmentObserver implements Observer<List<TvSeries>> {

        @Override
        public void onSubscribe(Disposable d) {
            disposable.add(d);
        }

        @Override
        public void onNext(List<TvSeries> tvSeries) {
            series.postValue(new ResourceModel<>(ResourceModel.State.SUCCESS, tvSeries, null));
        }

        @Override
        public void onError(Throwable e) {
            series.postValue(new ResourceModel<>(ResourceModel.State.ERROR, null, e.getMessage()));
        }

        @Override
        public void onComplete() {
            // do nothing
        }
    }
}
