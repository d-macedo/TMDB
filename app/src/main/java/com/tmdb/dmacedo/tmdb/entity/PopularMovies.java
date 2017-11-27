package com.tmdb.dmacedo.tmdb.entity;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class PopularMovies extends Movies implements Parcelable {

    @SerializedName("genre_ids")
    private List<Long> genreIds;

    public PopularMovies(Long id, String title, String originalTitle, Date releaseDate, String overview, Boolean adult,
                         String originalLanguage, Double popularity, Double voteAverage, Long voteCount, Boolean video, String posterPath,
                         String backdropPath, List<Long> genreIds) {
        super(id, title, originalTitle, releaseDate, overview, adult, originalLanguage, popularity, voteAverage,
                voteCount, video, posterPath, backdropPath);
        this.genreIds = genreIds;
    }

    protected PopularMovies(Parcel in) {
        setId(in.readLong());
        setTitle(in.readString());
        setOverview(in.readString());
        setBackdropPath(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(getId());
        dest.writeString(getTitle());
        dest.writeString(getOverview());
        dest.writeString(getBackdropPath());
    }

    public static final Creator<PopularMovies> CREATOR = new Creator<PopularMovies>() {
        @Override
        public PopularMovies createFromParcel(Parcel in) {
            return new PopularMovies(in);
        }

        @Override
        public PopularMovies[] newArray(int size) {
            return new PopularMovies[size];
        }
    };

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Long> genreIds) {
        this.genreIds = genreIds;
    }
}
