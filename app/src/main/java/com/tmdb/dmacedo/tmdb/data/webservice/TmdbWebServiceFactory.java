package com.tmdb.dmacedo.tmdb.data.webservice;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TmdbWebServiceFactory {

    public static TmdbWebService runWebService(OkHttpClient httpClient){
        return new Retrofit.Builder()
                .baseUrl(TmdbWebService.BASE_URL)
                .client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TmdbWebService.class);
    }

}
