
package bean;

/**
 *
 * @author Gavin
 */
public class TableBean {
    
    private int tableID;
    private int restaurantID;
    private int tableState;
    private int seatAmount;
    
    public TableBean() {
        tableID = 0;
        restaurantID = 0;
        tableState = 0;
        seatAmount = 0;
    }

    public int getTableID() {
        return tableID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public int getTableState() {
        return tableState;
    }

    public int getSeatAmount() {
        return seatAmount;
    }

    public void setTableID(int tableID) {
        this.tableID = tableID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public void setTableState(int tableState) {
        this.tableState = tableState;
    }

    public void setSeatAmount(int seatAmount) {
        this.seatAmount = seatAmount;
    }
}
