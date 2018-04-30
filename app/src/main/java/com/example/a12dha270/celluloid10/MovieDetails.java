package com.example.a12dha270.celluloid10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a12dha270.celluloid10.MoviePackage.MovieClass;
import com.example.a12dha270.celluloid10.database.MovieDatabaseSource;

public class MovieDetails extends AppCompatActivity {
    private TextView movieTitleTV;
    private TextView movieDirectorTV;
    private TextView movieCategoryTV;
    private TextView movieLanguageTV;
    private TextView movieCountryTV;
    private TextView movieActorTV;
    private TextView movieActressTV;
    private TextView movieDurationTV;
    private TextView movieReleaseDateTV;
    private TextView movieProducerTV;
    private TextView movieTypeTV;
    private MovieClass movie;
    private MovieDatabaseSource source;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        movieTitleTV = findViewById(R.id.movieTitleTV);
        movieDirectorTV = findViewById(R.id.movieDirectorTV);
        movieCategoryTV = findViewById(R.id.movieCategoryTV);
        movieLanguageTV = findViewById(R.id.movieLanguageTV);
        movieCountryTV = findViewById(R.id.movieCountryTV);
        movieActorTV = findViewById(R.id.movieActorTV);
        movieActressTV = findViewById(R.id.movieActressTV);
        movieDurationTV = findViewById(R.id.movieDurationTV);
        movieReleaseDateTV = findViewById(R.id.movieReleaseDateTV);
        movieProducerTV = findViewById(R.id.movieProducerTV);
        movieTypeTV = findViewById(R.id.movieTypeTV);
        source = new MovieDatabaseSource(this);

        Intent intent = getIntent();
        index = intent.getIntExtra("msg", 1);
        movie = source.getMovieDetailById(index);

        if (movie != null) {
            movieTitleTV.setText(movie.getMovieName());
            movieDirectorTV.setText(movie.getMovieDirector());
            movieCategoryTV.setText(movie.getMovieCategory());
            movieLanguageTV.setText(movie.getMovieLanguage());
            movieCountryTV.setText(movie.getMovieCountry());
            movieActorTV.setText(movie.getMovieActor());
            movieActressTV.setText(movie.getMovieActress());
            movieDurationTV.setText(movie.getMovieDuration());
            movieReleaseDateTV.setText(movie.getMovieReleaseDate());
            movieProducerTV.setText(movie.getMovieProducer());
            movieTypeTV.setText(movie.getMovieType());
            Toast.makeText(this, "Ok", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Some Problem", Toast.LENGTH_LONG).show();
        }
    }
    public void btnDelete(View view) {
        if(source.deleteMovieItem(index)){
            Toast.makeText(this,"Delete Successful",Toast.LENGTH_LONG).show();
            Intent intent =new Intent(MovieDetails.this,MovieList.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"Delete Unsuccessful",Toast.LENGTH_LONG).show();
        }

    }

    public void btnEdit(View view) {
        Intent intent = new Intent(MovieDetails.this, MovieEntryForm.class);
        intent.putExtra("msg", index);
        startActivity(intent);
    }
}

