package com.tmdb.dmacedo.tmdb.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;


public class TvSeries  implements Parcelable{

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("popularity")
    private Double popularity;

    @SerializedName("id")
    private int id;

    @SerializedName("backdrop_path")
    private String backdropPath;

    @SerializedName("vote_average")
    private Double voteAverage;

    @SerializedName("overview")
    private String overview;

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("origin_country")
    private List<String> originCountries;

    @SerializedName("genre_ids")
    private List<Long> genreIds;

    @SerializedName("original_language")
    private String originalLanguage;

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("name")
    private String name;

    @SerializedName("original_name")
    private String originalName;


    public TvSeries() {
    }

    public TvSeries(String posterPath, Double popularity, int id, String backdropPath, Double voteAverage, String overview, String firstAirDate, List<String> originCountries, List<Long> genreIds, String originalLanguage, int voteCount, String name, String originalName) {
        this.posterPath = posterPath;
        this.popularity = popularity;
        this.id = id;
        this.backdropPath = backdropPath;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.firstAirDate = firstAirDate;
        this.originCountries = originCountries;
        this.genreIds = genreIds;
        this.originalLanguage = originalLanguage;
        this.voteCount = voteCount;
        this.name = name;
        this.originalName = originalName;
    }

    protected TvSeries(Parcel in) {
        posterPath = in.readString();
        if (in.readByte() == 0) {
            popularity = null;
        } else {
            popularity = in.readDouble();
        }
        id = in.readInt();
        backdropPath = in.readString();
        if (in.readByte() == 0) {
            voteAverage = null;
        } else {
            voteAverage = in.readDouble();
        }
        overview = in.readString();
        firstAirDate = in.readString();
        originCountries = in.createStringArrayList();
        originalLanguage = in.readString();
        voteCount = in.readInt();
        name = in.readString();
        originalName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(posterPath);
        if (popularity == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(popularity);
        }
        dest.writeInt(id);
        dest.writeString(backdropPath);
        if (voteAverage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(voteAverage);
        }
        dest.writeString(overview);
        dest.writeString(firstAirDate);
        dest.writeStringList(originCountries);
        dest.writeString(originalLanguage);
        dest.writeInt(voteCount);
        dest.writeString(name);
        dest.writeString(originalName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TvSeries> CREATOR = new Creator<TvSeries>() {
        @Override
        public TvSeries createFromParcel(Parcel in) {
            return new TvSeries(in);
        }

        @Override
        public TvSeries[] newArray(int size) {
            return new TvSeries[size];
        }
    };

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public List<String> getOriginCountries() {
        return originCountries;
    }

    public void setOriginCountries(List<String> originCountries) {
        this.originCountries = originCountries;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Long> genreIds) {
        this.genreIds = genreIds;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }
}
