/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.TableTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface TableTableFacadeLocal {

    void create(TableTable tableTable);

    void edit(TableTable tableTable);

    void remove(TableTable tableTable);

    TableTable find(Object id);

    List<TableTable> findAll();

    List<TableTable> findRange(int[] range);

    int count();
    
}
