package com.tmdb.dmacedo.tmdb.infrastructure.di;


import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler computation();

    Scheduler main();
}
