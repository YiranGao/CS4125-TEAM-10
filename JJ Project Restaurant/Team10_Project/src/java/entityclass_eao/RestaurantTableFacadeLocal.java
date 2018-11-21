/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityclass_eao;

import entityclass.RestaurantTable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface RestaurantTableFacadeLocal {

    void create(RestaurantTable restaurantTable);

    void edit(RestaurantTable restaurantTable);

    void remove(RestaurantTable restaurantTable);

    RestaurantTable find(Object id);

    List<RestaurantTable> findAll();

    List<RestaurantTable> findRange(int[] range);

    int count();
    
}
