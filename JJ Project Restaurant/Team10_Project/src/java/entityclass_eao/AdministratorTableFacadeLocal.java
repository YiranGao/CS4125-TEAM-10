/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.AdministratorTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface AdministratorTableFacadeLocal {

    void create(AdministratorTable administratorTable);

    void edit(AdministratorTable administratorTable);

    void remove(AdministratorTable administratorTable);

    AdministratorTable find(Object id);

    List<AdministratorTable> findAll();

    List<AdministratorTable> findRange(int[] range);

    int count();
    
}
