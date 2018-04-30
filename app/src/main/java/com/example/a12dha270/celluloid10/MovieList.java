package com.example.a12dha270.celluloid10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a12dha270.celluloid10.MoviePackage.ListViewAdapter;
import com.example.a12dha270.celluloid10.MoviePackage.MovieClass;
import com.example.a12dha270.celluloid10.MoviePackage.MovieListAdapter;
import com.example.a12dha270.celluloid10.Preference.LoginPreferences;
import com.example.a12dha270.celluloid10.database.MovieDatabaseSource;

import java.util.ArrayList;
import java.util.List;

public class MovieList extends AppCompatActivity {
    private ListViewAdapter ListAdapter;
    private List<MovieClass> movieList = new ArrayList<>();
    private MovieDatabaseSource source;
    private ListView movieLV;
    private TextView warningText;
    private MovieListAdapter adapter;
    private LoginPreferences loginPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        loginPreferences = new LoginPreferences(this);

        movieLV = findViewById(R.id.movieLV);

        warningText = findViewById(R.id.warning);
        source = new MovieDatabaseSource(this);

        movieList = source.getAllMovies();
        if (movieList.size() == 0) {
            warningText.setText("Sorry, no data found!");
        } else {
            ListAdapter = new ListViewAdapter(this, movieList);
            movieLV.setAdapter(ListAdapter);
        }
    }

    public void categoryView(View view) {
        Intent intent= new Intent(MovieList.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add:
                startActivity(new Intent(MovieList.this,MovieEntryForm.class));
                break;
            case R.id.item_logout:
                loginPreferences.setStatus(false);
                startActivity(new Intent(MovieList.this,AdminLogin.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
