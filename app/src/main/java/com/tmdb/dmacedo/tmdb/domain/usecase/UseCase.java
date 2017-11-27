package com.tmdb.dmacedo.tmdb.domain.usecase;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;

/**
 * Base abstract class for Use cases.
 *
 * @param <R> Expected result type
 */

public abstract class UseCase<R> {

    protected abstract Observable<R> createObservable();

    public void execute(Scheduler subscriberScheduler, Scheduler observerScheduler, Observer<R> observer){
        createObservable()
                .subscribeOn(subscriberScheduler)
                .observeOn(observerScheduler)
                .subscribe(observer);
    }

}
