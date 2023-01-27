package com.driver;

public class Movie {

    private String name;
    private int DurationInMinutes;
    private double imdbRating;

    public Movie() {
    }

    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        DurationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return DurationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        DurationInMinutes = durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
