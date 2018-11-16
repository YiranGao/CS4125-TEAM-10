/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author admin
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
        resources.add(entityclass.service.AdministratorTableRESTFacade.class);
        resources.add(entityclass.service.CreditcardTableRESTFacade.class);
        resources.add(entityclass.service.CustomerTableRESTFacade.class);
        resources.add(entityclass.service.FeedbackTableRESTFacade.class);
        resources.add(entityclass.service.FronthouseTableRESTFacade.class);
        resources.add(entityclass.service.ReservationTableRESTFacade.class);
        resources.add(entityclass.service.RestaurantTableRESTFacade.class);
        resources.add(entityclass.service.TableTableRESTFacade.class);
        resources.add(entityclass.service.WaiterTableRESTFacade.class);
    }
    
}
