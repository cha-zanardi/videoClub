package com.videoclub.service;

import com.videoclub.controller.model.TagReponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.TagDao;

import java.util.List;
import java.util.stream.Collectors;

public class TagService {

    public List<TagReponse> fetchAll() {
        TagDao tagDao = DaoFactory.getTagDao();

        return tagDao
                .findAll()
                .stream()
                .map(m -> m.toDto())
                .collect(Collectors.toList());
    }
}
