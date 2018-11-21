/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.RestaurantTable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class RestaurantTableFacade extends AbstractFacade<RestaurantTable> implements RestaurantTableFacadeLocal {

    @PersistenceContext(unitName = "Team10_ProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RestaurantTableFacade() {
        super(RestaurantTable.class);
    }
    
}
