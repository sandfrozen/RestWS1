/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Message;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import resources.MessageService;

/**
 *
 * @author tomek.buslowski
 */
@Path("/messages")
public class MessageResource {

    MessageService messageService = MessageService.getInstance();

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
    public Message getMessage(@PathParam("messageId") Long id) {

        return messageService.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) {

        return messageService.createMessage(message);
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
