/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.WaiterTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface WaiterTableFacadeLocal {

    void create(WaiterTable waiterTable);

    void edit(WaiterTable waiterTable);

    void remove(WaiterTable waiterTable);

    WaiterTable find(Object id);

    List<WaiterTable> findAll();

    List<WaiterTable> findRange(int[] range);

    int count();
    
}
