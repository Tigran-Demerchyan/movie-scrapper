package com.tiko.scrapper.dto;

import com.tiko.scrapper.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieDto {
    private String title;
    private int year;
    private double rating;

    public MovieDto(Movie movie) {
        this.title = movie.getTitle();
        this.year=movie.getYear();
        this.rating=movie.getRating();
    }
}
