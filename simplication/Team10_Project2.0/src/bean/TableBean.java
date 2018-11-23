/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author gtara
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
