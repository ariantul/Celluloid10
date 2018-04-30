package com.example.a12dha270.celluloid10.MoviePackage;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a12dha270.celluloid10.R;
import com.example.a12dha270.celluloid10.database.MovieDatabaseSource;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FullLength extends Fragment {
    private MovieClass movie=new MovieClass();
    private MovieListAdapter movieListAdapter;
    private List<MovieClass> movieList=new ArrayList<>();
    private MovieDatabaseSource source;
    private TextView warningText;
    private RecyclerView fullLengthRecyclerView;


    public FullLength() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_full_length, container, false);
        fullLengthRecyclerView=rootView.findViewById(R.id.fullLengthRecyclerView);

        warningText=rootView.findViewById(R.id.warning);
        source=new MovieDatabaseSource(getContext());
        movieList=source.getSelectedTypeMovies("Full Length");
        if (movieList.size()==0){
            warningText.setText("Sorry, data not found!");
        }else{

            movieListAdapter=new MovieListAdapter(movieList,getContext());
            LinearLayoutManager llm=new LinearLayoutManager(getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            fullLengthRecyclerView.setLayoutManager(llm);
            fullLengthRecyclerView.setAdapter(movieListAdapter);
        }

        return rootView;
    }

    @Override
    public void onPause() {
        //Toast.makeText(getContext(),"Desserts Fragment Pause",Toast.LENGTH_LONG).show();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        //Toast.makeText(getContext(),"Desserts Fragment Destroy",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        //Toast.makeText(getContext(),"Desserts Fragment onAttach",Toast.LENGTH_LONG).show();
    }
}
