/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.ReservationTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface ReservationTableFacadeLocal {

    void create(ReservationTable reservationTable);

    void edit(ReservationTable reservationTable);

    void remove(ReservationTable reservationTable);

    ReservationTable find(Object id);

    List<ReservationTable> findAll();

    List<ReservationTable> findRange(int[] range);

    int count();
    
}
