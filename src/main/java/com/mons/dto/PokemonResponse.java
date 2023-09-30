package com.mons.dto;

import java.util.List;

public class PokemonResponse {
    private int count;
    private String next;
    private String previous;
    private List<PokemonResource> results;

    // getters and setters

    public static class PokemonResource {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        // constructor
        public PokemonResource(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public PokemonResource() {
        }

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokemonResource> getResults() {
        return results;
    }

    public void setResults(List<PokemonResource> results) {
        this.results = results;
    }

    public PokemonResponse() {
    }

    public PokemonResponse(int count, String next, String previous, List<PokemonResource> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

}