package com.tmdb.dmacedo.tmdb.application.activity.detail;

import android.media.Image;
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
import com.tmdb.dmacedo.tmdb.entity.PopularMovies;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE_ID = "id";

    private TextView mDetailText;

    private ImageView mBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDetailText = findViewById(R.id.detail_content_text);
        mBackground = findViewById(R.id.detail_background_img);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PopularMovies movie = getIntent().getParcelableExtra(EXTRA_MOVIE_ID);

        mDetailText.setText(movie.getOverview());


        String bgPath = TmdbWebService.BASE_IMG_URL + "w500" + movie.getBackdropPath();
        Picasso.with(this).load(bgPath).placeholder(R.drawable.ic_launcher_background).into(mBackground);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(movie.getTitle());





    }
}
