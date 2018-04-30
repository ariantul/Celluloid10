package com.example.a12dha270.celluloid10.MoviePackage;

public class MovieClass {
    private int index;
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
    private String movieType;

    public MovieClass() {
        this.movieName = this.movieName;
        this.movieDirector = this.movieDirector;
        this.movieCategory = this.movieCategory;
        this.movieLanguage = this.movieLanguage;
        this.movieCountry = this.movieCountry;
        this.movieActor = this.movieActor;
        this.movieActress = this.movieActress;
        this.movieDuration = this.movieDuration;
        this.movieReleaseDate = this.movieReleaseDate;
        this.movieProducer = this.movieProducer;
        this.movieType = this.movieType;
    }

    public MovieClass(int index, String movieName, String movieDirector, String movieCategory, String movieLanguage, String movieCountry, String movieActor, String movieActress, String movieDuration, String movieReleaseDate, String movieProducer, String movieType) {
        this.index = index;
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieCategory = movieCategory;
        this.movieLanguage = movieLanguage;
        this.movieCountry = movieCountry;
        this.movieActor = movieActor;
        this.movieActress = movieActress;
        this.movieDuration = movieDuration;
        this.movieReleaseDate = movieReleaseDate;
        this.movieProducer = movieProducer;
        this.movieType = movieType;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public String getMovieActress() {
        return movieActress;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public String getMovieProducer() {
        return movieProducer;
    }

    public String getMovieType() {
        return movieType;
    }

    public int getIndex() {
        return index;
    }

}
