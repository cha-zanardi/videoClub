package com.videoclub.controller;

import com.videoclub.controller.model.CreateTag;
import com.videoclub.controller.model.TagReponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.TagDao;
import com.videoclub.dao.entity.Tag;
import com.videoclub.service.TagService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("tags")
public class TagController {

    @Inject
    TagService tagService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<TagReponse> tagReponses = tagService.fetchAll();
        return Response.ok(tagReponses).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateTag createTag) {
        Tag tag = new Tag(createTag.getTag());
        TagDao tagDao = DaoFactory.getTagDao();
        tagDao.save(tag);
        return Response.status(201).build();
    }

}
