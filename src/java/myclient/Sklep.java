/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import myclasses.ResponseList;
import service.SearchParam;

/**
 * Jersey REST client generated for REST resource:SklepResource [sklep]<br>
 * USAGE:
 * <pre>
 *        Sklep client = new Sklep();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author tomek.buslowski
 */
public class Sklep {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RestWS1/webresources";

    public Sklep() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("sklep");
    }

    public <T> T getAllProdukty(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("allproducts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public ResponseList findProducts(String name, String producent, int cena) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findProducts");
        
        SearchParam searchParam = new SearchParam();
        searchParam.setNazwa(name);
        searchParam.setProducent(producent);
        searchParam.setCenaMniejszaNiz(cena);
        
        ResponseList responseList = resource.request(MediaType.APPLICATION_JSON).post(Entity.entity(searchParam, MediaType.APPLICATION_JSON), ResponseList.class);
        
        return responseList;
    }

    public void close() {
        client.close();
    }
    
}
