
package bean;

/**
 *
 * @author Gavin
 */
public class RestaurantBean {
    
    private int restaurant_id;
    private String name;
    private String location;
    private int tableAmount;
    
    public RestaurantBean(){
        restaurant_id = 0;
        name = "";
        location = "";
        tableAmount = 0;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTableAmount(int tableAmount) {
        this.tableAmount = tableAmount;
    }
    
    public int getRestaurant_id() {
        return restaurant_id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getTableAmount() {
        return tableAmount;
    }
   
}
