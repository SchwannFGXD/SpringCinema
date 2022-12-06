package com.example.TheSpringCinema.Repositories;
import com.example.TheSpringCinema.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepositories extends JpaRepository<Movie, Integer>{
}

