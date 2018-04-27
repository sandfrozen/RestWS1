/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Message;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import resources.MessageService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author tomek.buslowski
 */
@Path("/messages")
public class MessageResource {

    MessageService messageService = MessageService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getText2() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@PathParam("id") int id) {
        if (id > -1 && id < messageService.getAllMessages().size()) {
            return Response.status(201).entity(messageService.getAllMessages().get(id)).build();
        } else {
            return Response.status(400).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message) {

        String result = "Message created : " + message.getAuthor();
        messageService.addMessage(message);
        return Response.status(201).entity(result).build();
    }

}
