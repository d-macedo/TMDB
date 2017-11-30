package com.tmdb.dmacedo.tmdb.data.webservice.response;

import com.google.gson.annotations.SerializedName;
import com.tmdb.dmacedo.tmdb.entity.TvSeries;

import java.util.List;

/**
 * Created by Daniel on 29/11/2017.
 */

public class TvSeriesResponse {

    @SerializedName("page")
    int page;

    @SerializedName("total_results")
    int totalResults;

    @SerializedName("total_pages")
    int totalPages;

    @SerializedName("results")
    List<TvSeries> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<TvSeries> getResults() {
        return results;
    }

    public void setResults(List<TvSeries> results) {
        this.results = results;
    }
}
