package com.example.TheSpringCinema.Services;

import com.example.TheSpringCinema.Models.Movie;
import com.example.TheSpringCinema.Repositories.MovieRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepositories movieRepositories;

    public MovieService() {
    }

    public void addMovie(String title, int rating, int duration){
        Movie movie = new Movie(title, rating, duration);
        movieRepositories.save(movie);
    }
    public void updateMovie(int id, String title, int rating, int duration){
        Movie movie = movieRepositories.findById(id).get();
        movie.setDuration(duration);
        movie.setRating(rating);
        movie.setTitle(title);
        movieRepositories.save(movie);
    }

    public void deleteMovie(int id){
        Movie movie = movieRepositories.findById(id).get();
        movieRepositories.delete(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepositories.findAll();
    }

    public Optional<Movie> getMovieById(int id){
        return movieRepositories.findById(id);
    }
}