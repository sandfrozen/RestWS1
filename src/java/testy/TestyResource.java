/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testy;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;

/**
 * REST Web Service
 *
 * @author tomek.buslowski
 */
@Path("/testy")
public class TestyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTesty() {
        return "This is Testy";
    }

    @GET
    @Path("/queryParam")
    public Response getQueryParam(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") List<String> orderBy) {

        return Response.status(200).entity("getQueryParam is called, from : " + from + ", to : " + to + ", orderBy" + orderBy.toString()).build();
    }

    @GET
    @Path("/queryUriInfo")
    public Response getQueryUriInfo(@Context UriInfo info) {

        String from = info.getQueryParameters().getFirst("from");
        String to = info.getQueryParameters().getFirst("to");
        List<String> orderBy = info.getQueryParameters().get("orderBy");

        return Response.status(200).entity("getQueryUriInfo is called, from : " + from + ", to : " + to + ", orderBy" + orderBy.toString() + "\n" + "URI Info: " + info.getAbsolutePath().toString()).build();
    }

    @GET
    @Path("{year}")
    public Response getMatrix(@PathParam("year") String year,
            @MatrixParam("author") String author,
            @MatrixParam("country") String country) {

        return Response.status(200).entity("getMatrix is called, year : " + year + ", author : " + author + ", country : " + country).build();
    }

    @GET
    @Path("/getHeader")
    public Response getHeader(@HeaderParam("user-agent") String userAgent) {

        return Response.status(200).entity("getHeader is called, userAgent : " + userAgent).build();

    }
}
