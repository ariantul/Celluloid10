package com.example.a12dha270.celluloid10.MoviePackage;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a12dha270.celluloid10.MovieDetails;
import com.example.a12dha270.celluloid10.R;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<MovieClass> {
    private Context context;
    private List<MovieClass> movie;
    private int count=0;


    public ListViewAdapter(@NonNull Context context, List<MovieClass> movie) {
        super(context, R.layout.movie_row_view, movie);
        this.movie=movie;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.movie_row_view,parent,false);

        TextView titleTV=convertView.findViewById(R.id.titleTV);
        TextView directorTV=convertView.findViewById(R.id.directorTV);
        TextView languageTV=convertView.findViewById(R.id.languageTV);
        TextView typeTV=convertView.findViewById(R.id.typeTV);
        Button btnDetails=convertView.findViewById(R.id.btnDetails);

        titleTV.setText(movie.get(position).getMovieName());
        directorTV.setText(movie.get(position).getMovieDirector());
        languageTV.setText(movie.get(position).getMovieLanguage());
        typeTV.setText(movie.get(position).getMovieType());

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieClass user = movie.get(position);
                Intent intent = new Intent(context,MovieDetails.class);
                intent.putExtra("msg",user.getIndex());
                context.startActivity(intent);
                Toast.makeText(context, "Details", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
