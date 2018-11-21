/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.CustomerTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface CustomerTableFacadeLocal {

    void create(CustomerTable customerTable);

    void edit(CustomerTable customerTable);

    void remove(CustomerTable customerTable);

    CustomerTable find(Object id);

    List<CustomerTable> findAll();

    List<CustomerTable> findRange(int[] range);

    int count();
    
}
