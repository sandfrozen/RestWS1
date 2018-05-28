/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Comment;
import model.Message;
import resources.CommentService;
import resources.MessageService;

/**
 * REST Web Service
 *
 * @author tomek.buslowski
 */
@Path("/comments")
public class CommentsResource {
    
    CommentService messageService = CommentService.getInstance();

    @Context
    private UriInfo context;

    public CommentsResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getCommetns(@PathParam("messageId") Long id) {
        return messageService.getCommentsFor(id);
    }
}