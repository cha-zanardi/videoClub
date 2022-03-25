package com.videoclub.dao.entity;

import com.videoclub.controller.model.ActorReponse;
import com.videoclub.controller.model.MovieReponse;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "actor")
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String firstname;
    private String lastname;

    public Actor() {
    }

    public Actor(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Actor toDto(){
        Actor m = new Actor();
        m.setId(this.id);
        m.setFirstname(this.firstname);
        m.setLastname(this.lastname);
        return m;
    }


}
