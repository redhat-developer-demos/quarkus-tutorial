package com.redhat.developers;

import java.sql.Date;
import java.util.List;

import com.redhat.developers.Swapi.Results;

public class MovieDTO {
    private String title;
    private Date releaseDate;
    private int episodeId;
    private String producer;
    private String director;
    private String opening_crawl;

    private MovieDTO(String title, Date releaseDate, int episodeId, String producer, String director,
            String opening_crawl) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.episodeId = episodeId;
        this.producer = producer;
        this.director = director;
        this.opening_crawl = opening_crawl;
    }

    public static MovieDTO of(Movie movie, Swapi swapi){
        List<Results> results = swapi.getResults();
        Results result = results.get(0);
        
        return new MovieDTO(
            movie.title,
            movie.releaseDate,
            result.getEpisodeId(),
            result.getProducer(),
            result.getDirector(),
            result.getOpening_crawl()
        );
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public String getProducer() {
        return producer;
    }

    public String getDirector() {
        return director;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }
}
