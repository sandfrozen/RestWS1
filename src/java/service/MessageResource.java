/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import filters.Logowanie;
import java.math.BigDecimal;
import java.net.URI;
import java.util.LinkedList;
import model.Message;
import java.util.List;
import javax.ejb.Singleton;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import resources.MessageService;

/**
 *
 * @author tomek.buslowski
 */
@Path("/messages")
@Logowanie
//@Singleton
public class MessageResource {

    int i = 0;

    @GET
    @Path("/iterator")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIterator() {
        return "i = " + i++;
    }

    MessageService messageService = MessageService.getInstance();

    @Path("{messageId}/comments")
    public CommentsResource getComments(@PathParam("messageId") Long id) {
        return new CommentsResource();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@QueryParam("zaczynasie") String par1) {
        if (par1 != null) {
            return messageService.getAllMessagesStartingWith(par1);
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getText2() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@PathParam("messageId") Long id, @Context UriInfo uriInfo) {
        Message message = messageService.getMessage(id);

        String self = uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(String.valueOf(message.getId()))
                .build().toString();
        message.addLink("self", self);

        String comments = uriInfo.getBaseUriBuilder()
                .path(MessageResource.class)
                .path(MessageResource.class, "getComments")
                .resolveTemplate("messageId", message.getId())
                .build().toString();
        message.addLink("comments", comments);

        return Response.ok(message).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage(Message message, @Context UriInfo uriInfo) {
        Message newMessage = messageService.createMessage(message);
        String newId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        Response response = Response.created(uri).entity(newMessage).build();

        return response;
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(Message message) {

        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
//    @Consumes(MediaType.APPLICATION_JSON+ ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteMessage(@PathParam("messageId") Long id) {
        messageService.deleteMessage(id);
    }
}
