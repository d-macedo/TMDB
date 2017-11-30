package com.tmdb.dmacedo.tmdb.data.mapper;

import com.tmdb.dmacedo.tmdb.data.webservice.response.TvSeriesResponse;
import com.tmdb.dmacedo.tmdb.entity.TvSeries;

import java.util.ArrayList;
import java.util.List;

public class TvSeriesMapper {

    public static List<TvSeries> transform(TvSeriesResponse response){
        List<TvSeries> series = new ArrayList<>();

        for (TvSeries serie : response.getResults()){
            TvSeries tvSeries = new TvSeries(
                    serie.getPosterPath(), serie.getPopularity(),serie.getId(), serie.getBackdropPath(), serie.getVoteAverage(),
                    serie.getOverview(), serie.getFirstAirDate(), serie.getOriginCountries(), serie.getGenreIds(),serie.getOriginalLanguage(),
                    serie.getVoteCount(),serie.getName(),serie.getOriginalName()
            );
            series.add(tvSeries);
        }
        return series;
    }
}
