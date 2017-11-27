package com.tmdb.dmacedo.tmdb.data.webservice.response;


import com.google.gson.annotations.SerializedName;
import com.tmdb.dmacedo.tmdb.entity.PopularMovies;

import java.util.List;

public class PopularMoviesResponse {

    @SerializedName("page")
    int page;

    @SerializedName("results")
    List<PopularMovies> results;

    @SerializedName("total_results")
    int total_results;

    @SerializedName("total_pages")
    int total_pages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<PopularMovies> getResults() {
        return results;
    }

    public void setResults(List<PopularMovies> results) {
        this.results = results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
