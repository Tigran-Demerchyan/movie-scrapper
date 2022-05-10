package com.tiko.scrapper.scrapper;

import com.tiko.scrapper.dto.MovieDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieScrapper {
    private static final String URL = "https://www.imdb.com/chart/top";


    public  List<MovieDto> getAllMovies() throws IOException {
        Document document = Jsoup.connect(URL).get();
        Elements allRows = document.select("tbody>tr");
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Element currentRow : allRows) {
            MovieDto dto = new MovieDto();
            Elements title = currentRow.select("td.titleColumn>a");
            Elements year = currentRow.select("td.titleColumn>span");
            Elements rating = currentRow.select("td>strong");

            String ratingText = rating.text();
            String titleText = title.text();
            String yearText = year.text();

            yearText = yearText.replaceAll("\\(", "");
            yearText = yearText.replaceAll("\\)", "");


            int yearInt = Integer.parseInt(yearText);
            double ratingDouble = Double.parseDouble(ratingText);

            dto.setTitle(titleText);
            dto.setYear(yearInt);
            dto.setRating(ratingDouble);
            movieDtos.add(dto);

        }
        return movieDtos;

    }
}
