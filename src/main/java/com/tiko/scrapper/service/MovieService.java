package com.tiko.scrapper.service;

import com.tiko.scrapper.dataJpa.MovieRepo;
import com.tiko.scrapper.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Transactional
public class MovieService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MovieRepo movieRepo;

    public List<Movie> getAllMovies() {
        List<Movie> allMovies = entityManager.createQuery("from Movie", Movie.class).getResultList();
        return allMovies;
    }

    public void saveMovie(Movie movie) {
        Movie existedMovie = movieRepo.findSingleBySomeTitleYearRating(movie.getTitle(), movie.getYear(), movie.getRating());
        if (existedMovie == null) {
            System.out.println("Added new movie " + movie);
            entityManager.persist(movie);
        }
    }

}
