/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Product;

/**
 *
 * @author tomek.buslowski
 */
@Path("/products")
public class ProductResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Product getProductInJSON() {

        Product product = new Product();
        product.setName("iPad 3");
        product.setQty(999);

        return product;
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createProductInJSON(Product product) {
        String result = "Product created : " + product.getName() + " " + product.getQty();
        System.out.println(product.getName());
        return Response.status(201).entity(result).build();

    }
}
