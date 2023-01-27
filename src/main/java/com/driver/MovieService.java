package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.createMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.createDirector(director);
    }
    public String pairDirectorMovie(String movie,String director){
        return movieRepository.createMovieDirector(movie,director);
    }
    public Movie getMovieByName(String movie){
        return movieRepository.getMovieByName(movie);
    }
    public Director getDirectorByName(String director){
        return movieRepository.getDirectorByName(director);
    }
    public List<String> getMoviesByDirectorName(String director){
        return movieRepository.getMoviesByDirectorName(director);
    }
    public List<String> findAllMovies(){
        return movieRepository.findllMovies();
    }
    public String deleteDirectorByName(String director){
        return movieRepository.deleteDirectorByName(director);
    }
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }

}
