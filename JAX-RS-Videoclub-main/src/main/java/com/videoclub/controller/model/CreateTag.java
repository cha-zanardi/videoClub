package com.videoclub.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class CreateTag implements Serializable {

    private String tag;

    public CreateTag() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "CreateTag{" +
                "tag='" + tag +
                '}';
    }
}
