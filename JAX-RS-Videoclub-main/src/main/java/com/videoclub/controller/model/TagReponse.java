package com.videoclub.controller.model;

import java.io.Serializable;

public class TagReponse implements Serializable {

    private Long id;
    private String tag;

    public TagReponse() {
    }

    public TagReponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
