package com.tiko.scrapper.scheduler;

import com.tiko.scrapper.controller.MovieController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MovieScheduler {

    @Autowired
    private MovieController movieController;

    @Scheduled(fixedRate = 10_000)
    public void movieSchedule() throws IOException {

        movieController.addMovie();


    }
}
