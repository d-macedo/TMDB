package com.tmdb.dmacedo.tmdb.application.injection;

import android.app.Application;

import com.tmdb.dmacedo.tmdb.application.TmdbApplication;
import com.tmdb.dmacedo.tmdb.application.injection.module.ActivityBuilder;
import com.tmdb.dmacedo.tmdb.application.injection.module.FragmentBuilder;
import com.tmdb.dmacedo.tmdb.application.injection.module.InfrastructureModule;
import com.tmdb.dmacedo.tmdb.application.injection.module.RepositoryModule;
import com.tmdb.dmacedo.tmdb.application.injection.module.WebServiceModule;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                WebServiceModule.class,
                RepositoryModule.class,
                InfrastructureModule.class,
                ActivityBuilder.class,
                FragmentBuilder.class
        }
)
public interface AppComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(TmdbApplication tmdbApplication);

}
