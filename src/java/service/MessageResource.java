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
import javax.ws.rs.core.Response;
import resources.MessageService;

/**
 *
 * @author tomek.buslowski
 */

@Path("/messages")
public class MessageResource {
    
    MessageService messageService = new MessageService();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("id") int id) {
        return messageService.getAllMessages().get(id);
    }
    
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getText2() {
        return messageService.getAllMessages();
    }
    
    @POST
    @Consumes("application/json")
    public Response createProductInJSON(Message message) {

        String result = "Message created : " + message;
        System.out.println(message.getAuthor());
        return Response.status(201).entity(result).build();
    }
}
