package com.tmdb.dmacedo.tmdb.data.webservice;


import com.tmdb.dmacedo.tmdb.data.webservice.response.PopularMoviesResponse;
import com.tmdb.dmacedo.tmdb.entity.Movies;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbWebService {

    String BASE_URL = "https://api.themoviedb.org/3/";

    String BASE_IMG_URL = "https://image.tmdb.org/t/p/";


    @GET("movie/popular")
    Single<PopularMoviesResponse> getPopularMovies();

    @GET("movie/detail/{movieId}")
    Single<String> getDetails(@Path("movieId") long id);


}
