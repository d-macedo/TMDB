package com.tmdb.dmacedo.tmdb.application.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tmdb.dmacedo.tmdb.R;
import com.tmdb.dmacedo.tmdb.application.activity.detail.DetailActivity;
import com.tmdb.dmacedo.tmdb.application.activity.main.adapter.MainAdapter;
import com.tmdb.dmacedo.tmdb.domain.usecase.main.MainUseCase;
import com.tmdb.dmacedo.tmdb.entity.PopularMovies;
import com.tmdb.dmacedo.tmdb.presentation.model.ResourceModel;
import com.tmdb.dmacedo.tmdb.presentation.viewmodel.main.MainViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_MOVIE_ID = "id";

    private RecyclerView mRecyclerView;

    @Inject
    protected MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.main_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));



        mainViewModel.loadMovies().observe(this, listResourceModel -> {
            if (listResourceModel != null && listResourceModel.getState().equals(ResourceModel.State.SUCCESS)) {
                mRecyclerView.setAdapter(new MainAdapter(listResourceModel.getData(), popularMovie -> {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(EXTRA_MOVIE_ID, popularMovie);
                    startActivity(intent);
                }));
            }
        });


    }


}
