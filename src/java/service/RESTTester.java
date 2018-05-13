/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.sun.xml.ws.encoding.ContentType;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Message;

/**
 *
 * @author tomek.buslowski
 */
public class RESTTester {

    private static Client client = ClientBuilder.newClient();

    public static void main(String args[]) {
//        getMessages();
//        getMessage(1);
        postNewMessage();
        getMessage(4);
    }

    private static void getMessages() {
        WebTarget target = client.target("http://localhost:8080/RestWS1/webresources/messages");
        Response response = target.request().get();
        System.out.println("Get Messages:");
        System.out.println("response: " + response);
        String messages = target.request(MediaType.APPLICATION_JSON).get(String.class);
        //List<Message> messagesList = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Message>>() { });
        System.out.println("messages: " + messages);
    }

    private static void getMessage(int id) {

        WebTarget target = client.target("http://localhost:8080/RestWS1/webresources/messages/" + id);

        Response response = target.request().get();

        System.out.println("Get Message " + id + ":");
        System.out.println("response: " + response);
        String message = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("message: " + message);
    }

    private static void postNewMessage() {
        WebTarget target = client.target("http://localhost:8080/RestWS1/webresources/messages/");
        Message message = new Message("Czwarta wiadomość", "Wiktor");
        Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(message, "application/json; charset=UTF-8"));

        System.out.println("Post New Message " + message.getId() + ": " + message.getAuthor() + ", " + message.getMessage());
        System.out.println("response: " + response);
    }
}
