package com.tmdb.dmacedo.tmdb.application.activity.main.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tmdb.dmacedo.tmdb.R;
import com.tmdb.dmacedo.tmdb.application.activity.detail.DetailActivity;
import com.tmdb.dmacedo.tmdb.application.activity.main.MainActivity;
import com.tmdb.dmacedo.tmdb.application.activity.main.adapter.MainAdapter;
import com.tmdb.dmacedo.tmdb.presentation.model.ResourceModel;
import com.tmdb.dmacedo.tmdb.presentation.viewmodel.main.MainViewModel;
import com.tmdb.dmacedo.tmdb.presentation.viewmodel.main.MovieFragmentViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MovieFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MovieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
        private static final String EXTRA_MOVIE_ID = "id";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;

    @Inject
    protected MovieFragmentViewModel mainViewModel;

    public MovieFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieFragment newInstance(String param1, String param2) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        mainViewModel.loadMovies().observe(this, listResourceModel -> {
            if (listResourceModel != null && listResourceModel.getState().equals(ResourceModel.State.SUCCESS)) {
                mRecyclerView.setAdapter(new MainAdapter(listResourceModel.getData(), popularMovie -> {
                    Intent intent = new Intent(this.getContext(), DetailActivity.class);
                    intent.putExtra(EXTRA_MOVIE_ID, popularMovie);
                    startActivity(intent);
                }));
            }
        });

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);

        mRecyclerView =  rootView.findViewById(R.id.main_recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2));

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
