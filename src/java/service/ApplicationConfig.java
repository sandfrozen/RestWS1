/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ejb.Singleton;
import javax.ws.rs.core.Application;

/**
 *
 * @author tomek.buslowski
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
//        resources.add(filters.LoginigFilter.class);
        resources.add(filters.LoginigFilter.class);
        resources.add(filters.MyResponseFilter.class);
        resources.add(filters.SecurityFilter.class);
        resources.add(service.CommentsResource.class);
        resources.add(service.HelloWorldService.class);
        resources.add(service.MessageResource.class);
        resources.add(service.ProductResource.class);
        resources.add(service.SklepResource.class);
        resources.add(testy.TestyResource.class);
    }
    
}
