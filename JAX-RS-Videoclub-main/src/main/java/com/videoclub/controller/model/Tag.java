package com.videoclub.controller.model;

import java.io.Serializable;

public class Tag implements Serializable {

    private Long id;
    private String tag;

    public Tag() {
    }

    public Tag(Long id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}