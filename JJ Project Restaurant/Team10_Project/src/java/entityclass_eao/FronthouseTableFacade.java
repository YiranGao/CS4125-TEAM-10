/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.FronthouseTable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class FronthouseTableFacade extends AbstractFacade<FronthouseTable> implements FronthouseTableFacadeLocal {

    @PersistenceContext(unitName = "Team10_ProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FronthouseTableFacade() {
        super(FronthouseTable.class);
    }
    
}
