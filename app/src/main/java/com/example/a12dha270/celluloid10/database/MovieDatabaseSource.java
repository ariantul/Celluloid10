package com.example.a12dha270.celluloid10.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.a12dha270.celluloid10.MoviePackage.MovieClass;

import java.util.ArrayList;
import java.util.List;


public class MovieDatabaseSource {
    private MovieDatabaseHelper helper;
    private SQLiteDatabase db;
    public static final String TAG="Data Base> ";

    public MovieDatabaseSource(Context context) {
        helper = new MovieDatabaseHelper(context);
    }

    public void open(){
        db = helper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }
    public boolean insertMovie(MovieClass movie){
        this.open();
        ContentValues values = new ContentValues();
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_NAME, movie.getMovieName());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DIRECTOR, movie.getMovieDirector());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_CATEGORY, movie.getMovieCategory());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_LANGUAGE, movie.getMovieLanguage());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_COUNTRY, movie.getMovieCountry());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTOR, movie.getMovieActor());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTRESS, movie.getMovieActress());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DURATION, movie.getMovieDuration());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_RELEASE_DATE, movie.getMovieReleaseDate());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_PRODUCER, movie.getMovieProducer());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_TYPE, movie.getMovieType());

        long insertedRow = db.insert(MovieDatabaseHelper.TABLE_MOVIE,null, values);
        this.close();
        if (insertedRow > 0){
            return true;
        }else {
            return false;
        }
    }

    public List<MovieClass> getAllMovies(){
        this.open();
        List<MovieClass>movies=new ArrayList<>();

        Cursor c = db.query(MovieDatabaseHelper.TABLE_MOVIE, null, null,null,null, null,null);
        if (c!=null && c.getCount()>0){
            c.moveToFirst();

            do {
                int index =c.getInt(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_ID));
                String movieName = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_NAME));
                String movieDirector = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DIRECTOR));
                String movieCategory = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_CATEGORY));
                String movieLanguage = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_LANGUAGE));
                String movieCountry = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_COUNTRY));
                String movieActor = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTOR));
                String movieActress = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTRESS));
                String movieDuration = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DURATION));
                String movieReleaseDate = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_RELEASE_DATE));
                String movieProducer = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_PRODUCER));
                String movieType = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_TYPE));

                MovieClass movie = new MovieClass(index,movieName,movieDirector,movieCategory,movieLanguage,movieCountry,movieActor,movieActress,movieDuration,movieReleaseDate,movieProducer,movieType);
                movies.add(movie);
            }while (c.moveToNext());
        }
        c.close();

        this.close();
        return movies;
    }

    public List<MovieClass> getSelectedTypeMovies(String type){
        this.open();
        List<MovieClass>movies=new ArrayList<>();

        //Cursor c = db.query(MovieDatabaseHelper.TABLE_FOOD, null, null,null,null, MovieDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE+" = "+type,null);
        Cursor c=db.rawQuery("SELECT * FROM "+ MovieDatabaseHelper.TABLE_MOVIE+" WHERE "+ MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_TYPE+" = '"+type+"'",null);
        if (c!=null && c.getCount()>0){
            c.moveToFirst();

            do {
                int index =c.getInt(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_ID));
                String movieName = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_NAME));
                String movieDirector = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DIRECTOR));
                String movieCategory = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_CATEGORY));
                String movieLanguage = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_LANGUAGE));
                String movieCountry = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_COUNTRY));
                String movieActor = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTOR));
                String movieActress = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTRESS));
                String movieDuration = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DURATION));
                String movieReleaseDate = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_RELEASE_DATE));
                String movieProducer = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_PRODUCER));
                String movieType = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_TYPE));
                MovieClass movie = new MovieClass(index,movieName,movieDirector,movieCategory,movieLanguage,movieCountry,movieActor,movieActress,movieDuration,movieReleaseDate,movieProducer,movieType);
                movies.add(movie);
            }while (c.moveToNext());
        }
        c.close();

        this.close();
        return movies;
    }

    public MovieClass getMovieDetailById(int rowId){
        this.open();
        MovieClass movie = null;
        Cursor c = db.query(MovieDatabaseHelper.TABLE_MOVIE,null, MovieDatabaseHelper.TABLE_MOVIE_COL_ID+" = "+rowId,null,null,null,null);
        if(c != null && c.getCount() > 0){
            c.moveToFirst();
            int index =c.getInt(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_ID));
            String movieName = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_NAME));
            String movieDirector = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DIRECTOR));
            String movieCategory = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_CATEGORY));
            String movieLanguage = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_LANGUAGE));
            String movieCountry = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_COUNTRY));
            String movieActor = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTOR));
            String movieActress = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTRESS));
            String movieDuration = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DURATION));
            String movieReleaseDate = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_RELEASE_DATE));
            String movieProducer = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_PRODUCER));
            String movieType = c.getString(c.getColumnIndex(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_TYPE));

            movie = new MovieClass(index,movieName,movieDirector,movieCategory,movieLanguage,movieCountry,movieActor,movieActress,movieDuration,movieReleaseDate,movieProducer,movieType);
        }
        c.close();
        this.close();
        return movie;
    }

    public boolean deleteMovieItem(int empId){
        this.open();
        int deletedRow = db.delete(MovieDatabaseHelper.TABLE_MOVIE, MovieDatabaseHelper.TABLE_MOVIE_COL_ID+" = "+empId,null);
        this.close();
        if(deletedRow > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean updateMovie(MovieClass movieClass){
        this.open();
        Log.d(TAG, "updateMovie: "+movieClass.getIndex());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieName());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieDirector());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieCategory());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieLanguage());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieCountry());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieActor());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieActress());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieDuration());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieReleaseDate());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieProducer());
        Log.d(TAG, "updateMovie: "+movieClass.getMovieType());
        ContentValues values = new ContentValues();
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_NAME,movieClass.getMovieName());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DIRECTOR,movieClass.getMovieDirector());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_CATEGORY,movieClass.getMovieCategory());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_LANGUAGE,movieClass.getMovieLanguage());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_COUNTRY,movieClass.getMovieCountry());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTOR,movieClass.getMovieActor());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_ACTRESS,movieClass.getMovieActress());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_DURATION,movieClass.getMovieDuration());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_RELEASE_DATE,movieClass.getMovieReleaseDate());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_PRODUCER,movieClass.getMovieProducer());
        values.put(MovieDatabaseHelper.TABLE_MOVIE_COL_MOVIE_TYPE,movieClass.getMovieType());
        int updatedRow = db.update(MovieDatabaseHelper.TABLE_MOVIE,values, MovieDatabaseHelper.TABLE_MOVIE_COL_ID+" = '"+movieClass.getIndex()+"'",null);

        this.close();
       if(updatedRow > 0){
            return true;
        }else{
            return false;
        }
    }

}
