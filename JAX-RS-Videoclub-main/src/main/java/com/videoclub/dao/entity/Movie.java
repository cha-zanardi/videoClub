package com.videoclub.dao.entity;

import com.videoclub.controller.model.MovieReponse;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    private double duration;
    private LocalDate releaseDate;

    public Movie() {
    }

    public Movie(String title, double duration, LocalDate releaseDate) {
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public MovieReponse toDto(){
        MovieReponse m = new MovieReponse();
        m.setId(this.id);
        m.setTitle(this.title);
        m.setDuration(this.duration);
        m.setReleaseDate(this.releaseDate);
        return m;
    }


}
