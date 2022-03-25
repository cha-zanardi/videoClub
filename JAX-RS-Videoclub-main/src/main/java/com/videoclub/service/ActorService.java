package com.videoclub.service;

import com.videoclub.dao.entity.Actor;
import com.videoclub.controller.model.MovieReponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.ActorDao;
import com.videoclub.dao.base.MovieDao;

import java.util.List;
import java.util.stream.Collectors;

public class ActorService {

    public List<Actor> fetchAll() {
        ActorDao actorDao = DaoFactory.getActorDao();

        return actorDao
                .findAll()
                .stream()
                .map(a -> a.toDto())
                .collect(Collectors.toList());
    }
}
