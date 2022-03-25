package com.videoclub.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class Movie implements Serializable {

    private Long id;
    private String title;
    private double duration;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate releaseDate;

    public Movie() {
    }

    public Movie(Long id, String title, double duration, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

//    public MovieResponse toDTO(){
//        MovieResponse m = new MovieResponse();
//        m.setId(this.id);
//        m.setTitle(this.title);
//        m.setDuration(this.duration);
//        m.releaseDate(this.releaseDate);
//        return m;
//    }

    public Movie(String title, double duration, LocalDate releaseDate) {
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}