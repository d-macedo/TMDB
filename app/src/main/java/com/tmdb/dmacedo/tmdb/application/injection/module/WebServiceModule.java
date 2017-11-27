package com.tmdb.dmacedo.tmdb.application.injection.module;

import com.tmdb.dmacedo.tmdb.data.webservice.InteceptorFactory;
import com.tmdb.dmacedo.tmdb.data.webservice.OkHttpClientFactory;
import com.tmdb.dmacedo.tmdb.data.webservice.TmdbWebService;
import com.tmdb.dmacedo.tmdb.data.webservice.TmdbWebServiceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Module
public class WebServiceModule {

    @Provides
    @Singleton
    static TmdbWebService provideWebService(OkHttpClient httpClient){
        return TmdbWebServiceFactory.runWebService(httpClient);
    }

    @Provides
    @Singleton
    static OkHttpClient providesHttpClient(Interceptor interceptor){
        return OkHttpClientFactory.create(interceptor);
    }

    @Provides
    @Singleton
    static Interceptor providesInterceptor (){
        return InteceptorFactory.create();
    }
}
