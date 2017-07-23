package com.example.ril.mytask1;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.RecyclerView;

public class OneFragment extends Fragment {


    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.activity_one_fragment,container,false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        movieList.clear();

        prepareMovieData();


        return view;


    }

    private void prepareMovieData() {

        Movie movie = new Movie("RED FT. Taylor Swift", "Red is the fourth studio album by American singer-songwriter Taylor Swift",R.drawable.taylorswiftred);
        movieList.add(movie);

        movie = new Movie("WHY NOT ME?", "Euphoria is the ninth studio album by Spanish singer Enrique Iglesias",R.drawable.enrique);
        movieList.add(movie);

        movie = new Movie("JUSTIFIED", "Justified is the debut studio album by American singerJustin Timberlake.",R.drawable.justintimberlake);
        movieList.add(movie);

        movie = new Movie("BABY FT ", "Baby is studio album by Justin beiber", R.drawable.justinb);
        movieList.add(movie);

        /*movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);*/

        mAdapter.notifyDataSetChanged();

    }

}
