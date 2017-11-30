package com.tmdb.dmacedo.tmdb.application.activity.main.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.tmdb.dmacedo.tmdb.R;
import com.tmdb.dmacedo.tmdb.data.webservice.TmdbWebService;
import com.tmdb.dmacedo.tmdb.entity.TvSeries;

import java.util.List;


public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {


    private List<TvSeries> mDataSet;

    private OnItemClickListener mOnItemClickListener;

    public TvAdapter(List<TvSeries> mDataSet, OnItemClickListener mOnItemClickListener) {
        this.mDataSet = mDataSet;
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_tv_list_item, parent, false);

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        String fullPath = TmdbWebService.BASE_IMG_URL + "w500" + mDataSet.get(position).getPosterPath();

        Picasso.with(holder.mImageView.getContext())
                .load(fullPath).placeholder(R.drawable.ic_launcher_background).into(holder.mImageView);

        holder.itemView.setOnClickListener(v -> {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClicked(mDataSet.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        ViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.imageview_thumbail_tv);
        }
    }


    public interface OnItemClickListener {
        void onItemClicked(TvSeries tvSeries);
    }

}
