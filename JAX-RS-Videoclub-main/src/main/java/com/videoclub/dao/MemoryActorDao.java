package com.videoclub.dao;

import com.videoclub.dao.base.ActorDao;
import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.entity.Actor;
import com.videoclub.dao.entity.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryActorDao implements ActorDao {

    private static Long idSequence = 0L;
    private static List<Actor> actors = new ArrayList<>();

    @Override
    public Long save(Actor actor) {
        actor.setId(++idSequence);
        actors.add(actor);
        return actor.getId();
    }

    @Override
    public List<Actor> findAll() {
        return Collections.unmodifiableList(actors);
    }

    @Override
    public Optional<Actor> findById(Long id) {
        return this.actors.stream()
                .filter(actor -> actor.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Actor actorToUpdate) {
        boolean isUpdate = false;
        List<Actor> tempList = new ArrayList<>();
        for (Actor m : actors) {
            if (m.getId() == actorToUpdate.getId()) {
                m = actorToUpdate;
                isUpdate = true;
            }
            tempList.add(m);
        }
        actors = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.actors = this.actors
                .stream()
                .filter(actor -> actor.getId() != id)
                .collect(Collectors.toList());
    }
}
