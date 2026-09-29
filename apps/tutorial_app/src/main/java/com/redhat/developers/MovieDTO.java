package com.redhat.developers;

import java.sql.Date;

public class MovieDTO {

    private String title;
    private Date releaseDate;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;

    public MovieDTO() {
    }

    private MovieDTO(String title, Date releaseDate, int episode_id, String opening_crawl, String director, String producer) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.episode_id = episode_id;
        this.opening_crawl = opening_crawl;
        this.director = director;
        this.producer = producer;
    }

    public static MovieDTO of(Movie movie, Swapi swapi) {
        return new MovieDTO(
                movie.title,
                movie.releaseDate,
                swapi.getEpisode_id(),
                swapi.getOpening_crawl(),
                swapi.getDirector(),
                swapi.getProducer()
        );
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
