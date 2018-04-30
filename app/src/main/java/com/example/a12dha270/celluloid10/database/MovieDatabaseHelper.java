package com.example.a12dha270.celluloid10.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MovieDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "movie_db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MOVIE = "tbl_movie";
    public static final String TABLE_MOVIE_COL_ID = "_id";
    public static final String TABLE_MOVIE_COL_MOVIE_NAME= "movie_name";
    public static final String TABLE_MOVIE_COL_MOVIE_DIRECTOR= "movie_director";
    public static final String TABLE_MOVIE_COL_MOVIE_CATEGORY= "movie_category";
    public static final String TABLE_MOVIE_COL_MOVIE_LANGUAGE= "movie_language";
    public static final String TABLE_MOVIE_COL_MOVIE_COUNTRY= "movie_country";
    public static final String TABLE_MOVIE_COL_MOVIE_ACTOR= "movie_actor";
    public static final String TABLE_MOVIE_COL_MOVIE_ACTRESS= "movie_actress";
    public static final String TABLE_MOVIE_COL_MOVIE_DURATION= "movie_duration";
    public static final String TABLE_MOVIE_COL_MOVIE_RELEASE_DATE= "movie_release_date";
    public static final String TABLE_MOVIE_COL_MOVIE_PRODUCER= "movie_producer";
    public static final String TABLE_MOVIE_COL_MOVIE_TYPE= "movie_type";

    public static final String CREATE_TABLE_MOVIE = "create table "+ TABLE_MOVIE + "(" +
            TABLE_MOVIE_COL_ID + " integer primary key, " +
            TABLE_MOVIE_COL_MOVIE_NAME + " text, " +
            TABLE_MOVIE_COL_MOVIE_DIRECTOR + " text, " +
            TABLE_MOVIE_COL_MOVIE_CATEGORY + " text, " +
            TABLE_MOVIE_COL_MOVIE_LANGUAGE + " text, " +
            TABLE_MOVIE_COL_MOVIE_COUNTRY + " text, " +
            TABLE_MOVIE_COL_MOVIE_ACTOR + " text, " +
            TABLE_MOVIE_COL_MOVIE_ACTRESS + " text, " +
            TABLE_MOVIE_COL_MOVIE_DURATION + " text, " +
            TABLE_MOVIE_COL_MOVIE_RELEASE_DATE + " text, " +
            TABLE_MOVIE_COL_MOVIE_PRODUCER + " text, " +
            TABLE_MOVIE_COL_MOVIE_TYPE + " text);";


    public MovieDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_MOVIE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
