package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    HashMap<String,Movie> moviemap=new HashMap<>();
    HashMap<String,Director> directormap=new HashMap<>();
    HashMap<String, List<String>> directormoviemap=new HashMap<>();

//    Add a movie: POST /movies/add-movie
//    Pass the Movie object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovie
    public void createMovie(Movie movie){
        moviemap.put(movie.getName(),movie);
    }
//    Add a director: POST /movies/add-director
//    Pass the Director object as request body
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addDirector
    public void createDirector(Director director){
        directormap.put(director.getName(),director);
    }
//    Pair an existing movie and director: PUT /movies/add-movie-director-pair
//    Pass movie name and director name as request parameters
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovieDirectorPair

    public String createMovieDirector(String movie,String director){

        List<String> movies=directormoviemap.getOrDefault(director,new ArrayList<>());
        if(movies.contains(movie)){
            return "Pair Already Exists";
        }
        movies.add(movie);
        directormoviemap.put(director,movies);
        return "Pair Added Successfully";
    }
//    Get Movie by movie name: GET /movies/get-movie-by-name/{name}
//    Pass movie name as path parameter
//    Return Movie object wrapped in a ResponseEntity object
//    Controller Name - getMovieByName
    public Movie getMovieByName(String movie){
        if(moviemap.containsKey(movie)){
            return moviemap.get(movie);
        }
        return null;
    }
//    Get Director by director name: GET /movies/get-director-by-name/{name}
//    Pass director name as path parameter
//    Return Director object wrapped in a ResponseEntity object
//    Controller Name - getDirectorByName

    public Director getDirectorByName(String director){
        if(directormap.containsKey(director)){
            return directormap.get(director);
        }
        return null;
    }

//    Get List of movies name for a given director name: GET /movies/get-movies-by-director-name/{director}
//    Pass director name as path parameter
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - getMoviesByDirectorName

    public List<String> getMoviesByDirectorName(String director){
        List<String> movieslist=new ArrayList<>();
        if(directormoviemap.containsKey(director)){
            movieslist=directormoviemap.get(director);
        }
        return movieslist;
    }
//    Get List of all movies added: GET /movies/get-all-movies
//    No params or body required
//    Return List of movies name(List()) wrapped in a ResponseEntity object
//    Controller Name - findAllMovies
    public List<String> findllMovies(){
        List<String> allmovies=new ArrayList<>();
        for(String movie:moviemap.keySet()){
            allmovies.add(movie);
        }
        return allmovies;
    }
//    Delete a director and its movies from the records: DELETE /movies/delete-director-by-name
//    Pass director’s name as request parameter
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteDirectorByName

    public String deleteDirectorByName(String director){
        List<String> movie=new ArrayList<>();
        if(directormoviemap.containsKey(director)){
            movie=directormoviemap.get(director);
        }
        for(String m:movie){
            if(directormoviemap.containsKey(m)){
                moviemap.remove(m);
            }
        }
        directormoviemap.remove(director);
        if(directormoviemap.containsKey(director)){
            directormoviemap.remove(director);
        }
        return "Director and their movies removed";
    }
//    Delete all directors and all movies by them from the records: DELETE /movies/delete-all-directors
//    No params or body required
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - deleteAllDirectors

    public String deleteAllDirectors(){
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: directormoviemap.keySet()){
            for(String movie: directormoviemap.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(moviemap.containsKey(movie)){
                moviemap.remove(movie);
            }
        }
        return "All director and movies deleted";
    }





}