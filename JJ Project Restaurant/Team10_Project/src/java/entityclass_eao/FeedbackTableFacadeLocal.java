/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.FeedbackTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface FeedbackTableFacadeLocal {

    void create(FeedbackTable feedbackTable);

    void edit(FeedbackTable feedbackTable);

    void remove(FeedbackTable feedbackTable);

    FeedbackTable find(Object id);

    List<FeedbackTable> findAll();

    List<FeedbackTable> findRange(int[] range);

    int count();
    
}
