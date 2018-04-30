package com.example.a12dha270.celluloid10.MoviePackage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a12dha270.celluloid10.R;

import java.util.List;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>  {
    private List<MovieClass> movieList;
    private Context context;
    private OnItemClickedListener listener;

    public Context getContext() {
        return context;
    }

    public interface OnItemClickedListener{
        void onItemClick(int position, MovieClass employee);
    }

    public void setOnItemClickedListener(OnItemClickedListener listener){
        this.listener=listener;
    }

    public MovieListAdapter(List<MovieClass> movieList, Context context) {
        this.context=context;
        this.movieList= (List<MovieClass>) movieList;
    }

    @NonNull
    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.movie_row_view, parent,false);
        return new MovieViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MovieViewHolder holder, final int position) {
        holder.titleTV.setText(movieList.get(position).getMovieName());
        holder.directorTV.setText(movieList.get(position).getMovieDirector());
        holder.languageTV.setText(movieList.get(position).getMovieLanguage());
        holder.typeTV.setText(movieList.get(position).getMovieType());
        holder.btnDetails.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder{
        TextView titleTV;
        TextView directorTV;
        TextView languageTV;
        TextView typeTV;
        LinearLayout parentLayout;
        Button btnDetails;

        public MovieViewHolder(final View itemView, final OnItemClickedListener listener) {
            super(itemView);

            titleTV=itemView.findViewById(R.id.titleTV);
            directorTV=itemView.findViewById(R.id.directorTV);
            languageTV=itemView.findViewById(R.id.languageTV);
            typeTV=itemView.findViewById(R.id.typeTV);
            parentLayout=itemView.findViewById(R.id.parentLayout);
            btnDetails=itemView.findViewById(R.id.btnDetails);
        }
    }

}
