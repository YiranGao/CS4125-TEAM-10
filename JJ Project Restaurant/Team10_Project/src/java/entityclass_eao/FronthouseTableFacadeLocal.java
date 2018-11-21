/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.FronthouseTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface FronthouseTableFacadeLocal {

    void create(FronthouseTable fronthouseTable);

    void edit(FronthouseTable fronthouseTable);

    void remove(FronthouseTable fronthouseTable);

    FronthouseTable find(Object id);

    List<FronthouseTable> findAll();

    List<FronthouseTable> findRange(int[] range);

    int count();
    
}
