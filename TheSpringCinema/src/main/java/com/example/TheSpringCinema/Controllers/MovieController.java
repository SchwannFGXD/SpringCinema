package com.example.TheSpringCinema.Controllers;

import com.example.TheSpringCinema.Models.Movie;
import com.example.TheSpringCinema.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity addNewMovie(@RequestParam(value = "title") String title,
                                      @RequestParam(value = "rating") int rating,
                                      @RequestParam(value = "duration") int duration) {
        movieService.addMovie(title,rating,duration);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PatchMapping(value = "/change/{id}")
    public ResponseEntity updateMovie(@PathVariable int id,
                                      @RequestParam(value = "title") String title,
                                      @RequestParam(value = "rating") int rating,
                                      @RequestParam(value = "duration") int duration) {
        movieService.updateMovie(id,title,rating,duration);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return new ResponseEntity(HttpStatus.GONE);
    }

}