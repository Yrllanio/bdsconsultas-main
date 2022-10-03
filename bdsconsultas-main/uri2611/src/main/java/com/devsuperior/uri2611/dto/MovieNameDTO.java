package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieNameProjection;

public class MovieNameDTO {

    private Long id;
    private String name;

    public MovieNameDTO(){
    }

    public MovieNameDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MovieNameDTO(MovieNameProjection movie) {
        id = movie.getId();
        name = movie.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MovieNameDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
