/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.ReservationTable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class ReservationTableFacade extends AbstractFacade<ReservationTable> implements ReservationTableFacadeLocal {

    @PersistenceContext(unitName = "Team10_ProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationTableFacade() {
        super(ReservationTable.class);
    }
    
}
