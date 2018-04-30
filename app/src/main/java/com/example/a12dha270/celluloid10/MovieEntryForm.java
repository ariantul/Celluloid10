package com.example.a12dha270.celluloid10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.a12dha270.celluloid10.MoviePackage.MovieClass;
import com.example.a12dha270.celluloid10.database.MovieDatabaseSource;

public class MovieEntryForm extends AppCompatActivity {
    private EditText movieTitleET;
    private EditText movieDirectorET;
    private EditText movieCategoryET;
    private EditText movieLanguageET;
    private EditText movieCountryET;
    private EditText movieActorET;
    private EditText movieActressET;
    private EditText movieDurationET;
    private EditText movieReleaseDateET;
    private EditText movieProducerET;
    private RadioGroup radioGroup;
    private Button btnCreate;
    private Button btnCancel;

    private String movieName;
    private String movieDirector;
    private String movieCategory;
    private String movieLanguage;
    private String movieCountry;
    private String movieActor;
    private String movieActress;
    private String movieDuration;
    private String movieReleaseDate;
    private String movieProducer;
    private int index;

    private MovieDatabaseSource source=new MovieDatabaseSource(this);
    private String movieType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_entry_form);
        movieTitleET=findViewById(R.id.movieTitleET);
        movieDirectorET=findViewById(R.id.movieDirectorET);
        movieCategoryET=findViewById(R.id.movieCategoryET);
        movieLanguageET=findViewById(R.id.movieLanguageET);
        movieCountryET=findViewById(R.id.movieCountryET);
        movieActorET=findViewById(R.id.movieActorET);
        movieActressET=findViewById(R.id.movieActressET);
        movieDurationET=findViewById(R.id.movieDurationET);
        movieReleaseDateET=findViewById(R.id.movieReleaseDateET);
        movieProducerET=findViewById(R.id.movieProducerET);
        radioGroup=findViewById(R.id.radioGroup);
        btnCreate=findViewById(R.id.btnCreate);
        btnCancel=findViewById(R.id.btnCancel);

        Intent intent=getIntent();
        index=intent.getIntExtra("msg",0);
        if (index>0){
            MovieClass movieClass=source.getMovieDetailById(index);
            movieTitleET.setText(movieClass.getMovieName());
            movieDirectorET.setText(movieClass.getMovieDirector());
            movieCategoryET.setText(movieClass.getMovieCategory());
            movieLanguageET.setText(movieClass.getMovieLanguage());
            movieCountryET.setText(movieClass.getMovieCountry());
            movieActorET.setText(movieClass.getMovieActor());
            movieActressET.setText(movieClass.getMovieActress());
            movieDurationET.setText(movieClass.getMovieDuration());
            movieReleaseDateET.setText(movieClass.getMovieReleaseDate());
            movieProducerET.setText(movieClass.getMovieProducer());
            if((movieClass.getMovieType().equals("Full Length"))){
                ((RadioButton)findViewById(R.id.fullLength)).setChecked(true);
            }
            if((movieClass.getMovieType().equals("Documentary"))){
                ((RadioButton)findViewById(R.id.docuMentary)).setChecked(true);
            }
            if((movieClass.getMovieType().equals("Short Film"))){
                ((RadioButton)findViewById(R.id.shortFilm)).setChecked(true);
            }
            btnCreate.setText("Update");
        }else {
            ((RadioButton)findViewById(R.id.fullLength)).setChecked(true);
        }


        RadioButton rb=findViewById(R.id.fullLength);
        movieType = rb.getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=findViewById(checkedId);
                movieType=rb.getText().toString();
                Toast.makeText(MovieEntryForm.this,movieType,Toast.LENGTH_LONG).show();
            }
        });

    }
    public void CancelAction(View view) {
        Toast.makeText(MovieEntryForm.this,"Cancel",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(MovieEntryForm.this,MovieList.class);
        startActivity(intent);
    }

    public void CreateItem(View view) {
        if (index>0){
            movieName=movieTitleET.getText().toString();
            movieDirector=movieDirectorET.getText().toString();
            movieCategory=movieCategoryET.getText().toString();
            movieLanguage=movieLanguageET.getText().toString();
            movieCountry=movieCountryET.getText().toString();
            movieActor=movieActorET.getText().toString();
            movieActress=movieActressET.getText().toString();
            movieDuration=movieDurationET.getText().toString();
            movieReleaseDate=movieReleaseDateET.getText().toString();
            movieProducer=movieProducerET.getText().toString();

            if (movieName.isEmpty()){
                movieTitleET.setError("Please fill in the movie name.");
                return;
            }
            if (movieDirector.isEmpty()){
                movieDirectorET.setError("Please fill in the movie director.");
                return;
            }
            if (movieCategory.isEmpty()){
                movieCategoryET.setError("Please fill in the movie category.");
                return;
            }
            if (movieLanguage.isEmpty()){
                movieLanguageET.setError("Please fill in the movie language.");
                return;
            }
            if (movieCountry.isEmpty()){
                movieCountryET.setError("Please fill in the movie country.");
                return;
            }
            if (movieActor.isEmpty()){
                movieActorET.setError("Please fill in the movie actor.");
                return;
            }
            if (movieActress.isEmpty()){
                movieActressET.setError("Please fill in the movie actress.");
                return;
            }
            if (movieDuration.isEmpty()){
                movieDurationET.setError("Please fill in the movie duration.");
                return;
            }
            if (movieReleaseDate.isEmpty()){
                movieReleaseDateET.setError("Please fill in the movie release date.");
                return;
            }
            if (movieProducer.isEmpty()){
                movieProducerET.setError("Please fill in the movie producer.");
                return;
            }

            MovieClass movie=new MovieClass(index,movieName,movieDirector,movieCategory,movieLanguage,movieCountry,movieActor,movieActress,movieDuration,movieReleaseDate,movieProducer,movieType);
            boolean status=source.updateMovie(movie);

            if (status){
                Toast.makeText(MovieEntryForm.this,"Information successfully updated.",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MovieEntryForm.this,MovieList.class);
                startActivity(intent);
            }else {
                Toast.makeText(MovieEntryForm.this,"Information not updated!",Toast.LENGTH_SHORT).show();
            }
        }else {
            movieName=movieTitleET.getText().toString();
            movieDirector=movieDirectorET.getText().toString();
            movieCategory=movieCategoryET.getText().toString();
            movieLanguage=movieLanguageET.getText().toString();
            movieCountry=movieCountryET.getText().toString();
            movieActor=movieActorET.getText().toString();
            movieActress=movieActressET.getText().toString();
            movieDuration=movieDurationET.getText().toString();
            movieReleaseDate=movieReleaseDateET.getText().toString();
            movieProducer=movieProducerET.getText().toString();

            if (movieName.isEmpty()){
                movieTitleET.setError("Please fill in the movie name.");
                return;
            }
            if (movieDirector.isEmpty()){
                movieDirectorET.setError("Please fill in the movie director.");
                return;
            }
            if (movieCategory.isEmpty()){
                movieCategoryET.setError("Please fill in the movie category.");
                return;
            }
            if (movieLanguage.isEmpty()){
                movieLanguageET.setError("Please fill in the movie language.");
                return;
            }
            if (movieCountry.isEmpty()){
                movieCountryET.setError("Please fill in the movie country.");
                return;
            }
            if (movieActor.isEmpty()){
                movieActorET.setError("Please fill in the movie actor.");
                return;
            }
            if (movieActress.isEmpty()){
                movieActressET.setError("Please fill in the movie actress.");
                return;
            }
            if (movieDuration.isEmpty()){
                movieDurationET.setError("Please fill in the movie duration.");
                return;
            }
            if (movieReleaseDate.isEmpty()){
                movieReleaseDateET.setError("Please fill in the movie release date.");
                return;
            }
            if (movieProducer.isEmpty()){
                movieProducerET.setError("Please fill in the movie producer.");
                return;
            }

            MovieClass movie=new MovieClass();
            boolean status=source.insertMovie(movie);
            if (status==true){
                Toast.makeText(MovieEntryForm.this,"Information inserted.",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MovieEntryForm.this,MovieList.class);
                startActivity(intent);
            }else {
                Toast.makeText(MovieEntryForm.this,"Information not inserted!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
