package com.tmdb.dmacedo.tmdb.application.activity.main.adapter;


import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tmdb.dmacedo.tmdb.R;
import com.tmdb.dmacedo.tmdb.data.webservice.TmdbWebService;
import com.tmdb.dmacedo.tmdb.entity.PopularMovies;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<PopularMovies> mDataset;

    private OnItemClickListener mOnClickListener;


    public MainAdapter(List<PopularMovies> mDataset, OnItemClickListener itemClickListener) {
        this.mDataset = mDataset;
        this.mOnClickListener = itemClickListener;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_movie_list_item, parent, false);

        WindowManager window = (WindowManager) parent.getContext().getSystemService(Context.WINDOW_SERVICE);

        if (window != null) {
            Point size = new Point();
            window.getDefaultDisplay().getSize(size);
            int width = size.x;
            int height = size.y;

            view.setLayoutParams(new RecyclerView.LayoutParams(width / 2, height / 2));
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {

        String fullPath = TmdbWebService.BASE_IMG_URL + "w500" + mDataset.get(position).getPosterPath();

        Picasso.with(holder.mImageView.getContext())
                .load(fullPath).placeholder(R.drawable.ic_launcher_background).into(holder.mImageView);

        holder.itemView.setOnClickListener(v -> {
            if (mOnClickListener != null){
                mOnClickListener.onItemClicked(mDataset.get(position));
            }
        });


        /*holder.mTextView.setText(mDataset.get(position).getTitle());*/
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextView;

        ViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.imageview_thumbail);
            /*mTextView = v.findViewById(R.id.text_title);*/
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(PopularMovies popularMovie);
    }
}
