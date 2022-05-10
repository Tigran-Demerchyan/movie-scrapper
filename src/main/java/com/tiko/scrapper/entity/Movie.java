package com.tiko.scrapper.entity;

import com.tiko.scrapper.dto.MovieDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "year")
    private int year;
    @Column(name = "rating")
    private double rating;

    public Movie(MovieDto dto) {
        this.title = dto.getTitle();
        this.year = dto.getYear();
        this.rating = dto.getRating();
    }
}
