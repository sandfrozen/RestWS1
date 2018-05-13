/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import model.Produkt;
import model.Produkty;

/**
 * REST Web Service
 *
 * @author tomek.buslowski
 */
@Path("sklep")
public class SklepResource {

    private Produkty produkty = new Produkty();
    
    
    @Context
    private UriInfo context;

    public SklepResource() {
    }
    
    @GET
    @Path("/allproducts")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseList getAllProdukty() {
        List<Produkt> allProdukty = produkty.getAllProdukty();
        ResponseList responseList = new ResponseList();
        responseList.setList(allProdukty);
        return responseList;
    }
    
    @POST
    @Path("/findProducts")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseList findProducts(SearchParam searchElement) {
        ResponseList responseList = new ResponseList();
        List<Produkt> resLista = produkty.findProduktyByNazwaProducentCenaMniejszaNiz(searchElement.getNazwa(), searchElement.getProducent(), searchElement.getCenaMniejszaNiz());
        responseList.setList(resLista);
        
        return responseList;
    } 
}
