package com.tmdb.dmacedo.tmdb.application.activity.detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tmdb.dmacedo.tmdb.R;
import com.tmdb.dmacedo.tmdb.data.webservice.TmdbWebService;
import com.tmdb.dmacedo.tmdb.entity.TvSeries;

public class TvDetailActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE_ID = "id";

    private TextView mTextView;

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextView = findViewById(R.id.tv_detail);
        mImageView = findViewById(R.id.detail_tv_background_img);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TvSeries serie = getIntent().getParcelableExtra(EXTRA_MOVIE_ID);

        mTextView.setText(serie.getOverview());
        String bgPath = TmdbWebService.BASE_IMG_URL + "w500" + serie.getBackdropPath();
        Picasso.with(this).load(bgPath).placeholder(R.drawable.ic_launcher_background).into(mImageView);

        getSupportActionBar().setTitle(serie.getName());



    }
}
