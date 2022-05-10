package com.tiko.scrapper.dataJpa;

import com.tiko.scrapper.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Query("from Movie m where m.title=:title and m.year=:year and m.rating=:rating")
    Movie findSingleBySomeTitleYearRating(@Param("title") String title, @Param("year") int year, @Param("rating") double rating);
}
