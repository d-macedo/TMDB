package com.tmdb.dmacedo.tmdb.data.webservice;


import com.tmdb.dmacedo.tmdb.BuildConfig;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class InteceptorFactory {

    private static final String API_NAME = "api_key";

    public static Interceptor create(){
        return chain -> {
            Request request = chain.request();
            HttpUrl url = request.url().newBuilder().addQueryParameter(API_NAME,BuildConfig.API_KEY).build();
            request = request.newBuilder().url(url).build();
            Response response = chain.proceed(request);
            return response;
        };
    }
}
