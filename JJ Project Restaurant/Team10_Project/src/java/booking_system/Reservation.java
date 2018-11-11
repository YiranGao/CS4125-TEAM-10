/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking_system;

public class Reservation {
    private String reservationID;
    private String custID;
    private String groupSize;
    private String time;
    private String date;
    private String tableID;
    private String restaurantID;
    
    public Reservation(String cID, String gS, String t, String d, String rID){
        reservationID = "";
        custID = cID;
        groupSize = gS;
        time = t;
        date = d;
        tableID = "";
        restaurantID = rID;
    }
    
    public Reservation(String cID, String gS, String t, String d, String tID, String rID){
        reservationID = "";
        custID = cID;
        groupSize = gS;
        time = t;
        date = d;
        tableID = tID;
        restaurantID = rID;
    }
    
    public Reservation(String resID, String cID, String gS, String t, String d, String tID, String rID){
        reservationID = resID;
        custID = cID;
        groupSize = gS;
        time = t;
        date = d;
        tableID = tID;
        restaurantID = rID;
    }

    public Reservation() {
        reservationID = "";
        custID = "";
        groupSize = "";
        time = "";
        date = "";
        tableID = "";
        restaurantID = "";
    }
    
    public String getResID(){
        return this.reservationID;
    }
    
    public void setResID(String rID){
        this.reservationID = rID;
    }
    
    public String getCustID(){
        return this.custID;
    }
    
    public void setCustID(String cID){
        this.custID = cID;
    }
    
    public String getGroupSize(){
        return this.groupSize;
    }
    
    public void setGroupSize(String gS){
        this.groupSize = gS;
    }
    
    public String getTime(){
        return this.time;
    }
    
    public void setTime(String t){
        this.time = t;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public void setDate(String d){
        this.date = d;
    }
    
    public String getTableID(){
        return this.tableID;
    }
    
    public void setTableID(String tID){
        this.tableID = tID;
    }
    
    public String getRestaurantID(){
        return this.restaurantID;
    }
    
    public void setRestaurantID(String rID){
        this.restaurantID = rID;
    }
}
