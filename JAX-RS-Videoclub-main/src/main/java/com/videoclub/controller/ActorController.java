package com.videoclub.controller;

import com.videoclub.dao.entity.Actor;
import com.videoclub.controller.model.CreateMovie;
import com.videoclub.controller.model.MovieReponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.MovieDao;
import com.videoclub.dao.entity.Movie;
import com.videoclub.service.ActorService;
import com.videoclub.service.MovieService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("actors")
public class ActorController {

    @Inject
    ActorService actorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Actor> actorReponses = actorService.fetchAll();
        return Response.ok(actorReponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Movie createMovie) {
        Movie movie = new Movie(createMovie.getTitle(), createMovie.getDuration(), createMovie.getReleaseDate());
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.save(movie);
        return Response.status(201).build();
    }


}
