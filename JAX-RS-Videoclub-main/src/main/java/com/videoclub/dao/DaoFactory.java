package com.videoclub.dao;

import com.videoclub.dao.base.ActorDao;
import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.base.TagDao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public final class DaoFactory {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");

    private DaoFactory() {
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static MovieDao getMovieDao(){
        return new MovieDaoImpl();
    }

    public static ActorDao getActorDao(){
        return new ActorDaoImpl();
    }

    public static TagDao getTagDao() {
        return new TagDaoImpl();
    }
}
