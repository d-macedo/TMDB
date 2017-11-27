package com.tmdb.dmacedo.tmdb.data.mapper;

import com.tmdb.dmacedo.tmdb.data.webservice.response.PopularMoviesResponse;
import com.tmdb.dmacedo.tmdb.entity.PopularMovies;

import java.util.ArrayList;
import java.util.List;

public class MainMapper {


    public static List<PopularMovies> transform (PopularMoviesResponse response){
        List<PopularMovies> movies = new ArrayList<>();

        for (PopularMovies movie : response.getResults()){
            PopularMovies popularMovies = new PopularMovies(
                    movie.getId(),movie.getTitle(),movie.getOriginalTitle(),
                    movie.getReleaseDate(),movie.getOverview(),movie.getAdult(),
                    movie.getOriginalLanguage(),movie.getPopularity(),movie.getVoteAverage(),
                    movie.getVoteCount(),movie.getVideo(),movie.getPosterPath(),movie.getBackdropPath(),movie.getGenreIds()
            );
            movies.add(popularMovies);
        }
        return movies;
    }
}
