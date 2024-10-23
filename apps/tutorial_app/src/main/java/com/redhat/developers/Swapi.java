package com.redhat.developers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Swapi {
    
    
    private List<Results> results;

    public Swapi(@JsonProperty("results") List<Results> results) {
        this.results = results;
    }

    public List<Results> getResults() {
        return results;
    }
    
    public static class Results {
        private int episodeId;
        private String producer;
        private String director;
        private String opening_crawl;

        public Results(int episodeId, String producer, String director, String opening_crawl) {
            this.episodeId = episodeId;
            this.producer = producer;
            this.director = director;
            this.opening_crawl = opening_crawl;
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
}
