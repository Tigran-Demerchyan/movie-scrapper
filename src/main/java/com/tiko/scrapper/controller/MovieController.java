package com.tiko.scrapper.controller;

import com.tiko.scrapper.dto.MovieDto;
import com.tiko.scrapper.entity.Movie;
import com.tiko.scrapper.scrapper.MovieScrapper;
import com.tiko.scrapper.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<MovieDto> showAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie currentMovie : allMovies) {
            MovieDto movieDto = new MovieDto(currentMovie);
            movieDtos.add(movieDto);
        }
        return movieDtos;

    }

    @PostMapping("/add")
    public void addMovie() throws IOException {
        MovieScrapper scrapper=new MovieScrapper();
        List<MovieDto> allMovies = scrapper.getAllMovies();

        for (MovieDto curr: allMovies){
            Movie movie = new Movie(curr);
            movieService.saveMovie(movie);
        }


    }
}
