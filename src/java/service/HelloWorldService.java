/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author tomek.buslowski
 */
@Path("/hello")
public class HelloWorldService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHtml() {
        return "Witaj JSX-RS";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/echo")
    public String getEcho() {
        return "Witaj Echo";
    }

    @GET
    @Path("/echo2/{parametr}")
    public String echo(@PathParam("parametr") String name) {
        return "Witaj " + name;
    }

    @GET
    @Path("/info")
    public String info(@HeaderParam("user-agent") String userAgent) {
        return "Witaj: " + userAgent;
    }

    @GET
    @Path("/info2")
    public String info2(@Context HttpHeaders headers) {
        String userAgent = headers.getRequestHeader("user-agent").get(0);
        for (String header : headers.getRequestHeaders().keySet()) {
            System.out.println(header);
        }

        return "Witaj: " + userAgent;
    }
}
