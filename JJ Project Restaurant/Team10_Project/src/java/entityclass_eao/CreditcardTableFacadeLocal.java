/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.CreditcardTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface CreditcardTableFacadeLocal {

    void create(CreditcardTable creditcardTable);

    void edit(CreditcardTable creditcardTable);

    void remove(CreditcardTable creditcardTable);

    CreditcardTable find(Object id);

    List<CreditcardTable> findAll();

    List<CreditcardTable> findRange(int[] range);

    int count();
    
}
