package com.videoclub.dao.entity;

import com.videoclub.controller.model.TagReponse;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tag")
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String tag;

    public Tag() {
    }

    public Tag(String tag) {
        this.setTag(tag);
    }

    public TagReponse toDto() {
        TagReponse t = new TagReponse();
        t.setId(this.id);
        t.setTag(this.tag);
        return t;
    }


}
