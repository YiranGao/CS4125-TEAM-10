    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myWS;

import booking_system.Reservation;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author gtara
 */
@WebService(serviceName = "Booking_Service")
public class Booking_Service {

    private MySQLAccess dao; 
    
    public Booking_Service() {
        dao = new MySQLAccess("localhost", "root", "", "booking_system");
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "makeBooking")
    public String makeBooking(@WebParam(name = "r") Reservation r) {
        String sqlCmd = "INSERT INTO reservation_table(customer_id,reservation_numofcover,reservation_bookingdate,table_id,restaurant_id) VALUES("+ r.getCustID() +", "+ r.getGroupSize() +", "+ r.getDate() +" "+ r.getTime() +", "+ r.getTableID() +", "+ r.getRestaurantID() +");";
        try {
            String result = dao.insert(sqlCmd);
            if(result.equals("INSERTED 1 ROWS.")) {
                sqlCmd = "SELECT reservation_ID FROM reservation_table WHERE customer_id = "+ r.getCustID() +" AND reservation_bookingdate = "+ r.getDate() +" "+ r.getTime() +" AND restaurant_id = "+ r.getRestaurantID() +" ORDER BY reservation_id DESC LIMIT 1;";
                try {
                    result = dao.retrieve(sqlCmd);
                    if(result.length() > 0) {
                        return result;
                    } else {
                        return "ERROR-NOTFOUND";
                    }
                } catch(Exception g) {
                    return "ERROR-RETRIEVE";
                }
            } else {
                return "ERROR-INSERT";
            }
        } catch(Exception e) {
            return "ERROR-DB";
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateBooking")
    public String updateBooking(@WebParam(name = "r") Reservation r) {
        String sqlCmd = "UPDATE INTO reservation_table(customer_id,reservation_numofcover,reservation_bookingdate,table_id,restaurant_id) VALUES("+ r.getCustID() +", "+ r.getGroupSize() +", "+ r.getDate() +" "+ r.getTime() +", "+ r.getTableID() +", "+ r.getRestaurantID() +" WHERE reservation_id = "+ r.getResID() +";";
        try {
            String result = dao.update(sqlCmd);
            if(result.equals("UPDATED 1 ROWS.")) {
                return "1";
            } else {
                return "0";
            }
        } catch(Exception e) {
            return "ERROR-DB";
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteBooking")
    public String deleteBooking(@WebParam(name = "r") Reservation r) {
        String sqlCmd = "SELECT COUNT(*) FROM reservation_table WHERE reservation_id = "+ r.getResID() +";";
        try {
            String result = dao.retrieve(sqlCmd);
            if(result.equals("1")) {
                sqlCmd = "DELETE FROM games WHERE reservation_id = "+ r.getResID()+";";
                result = dao.remove(sqlCmd);
                return "1";
            } else {
                return "ERROR-GAMESTARTED";
            }
        } catch(Exception e) {
            return "ERROR-DB";
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllBookings")
    public ArrayList<Reservation> getAllBookings() {
        ArrayList<Reservation> results = new ArrayList<>();
        String sqlCmd = "SELECT * FROM reservation_table;";
        try {
            String result = dao.retrieve(sqlCmd);
            results = processResults(result);
            if(result.length() > 0) {
                return results;
            } else {
                return null;
            }
        } catch(Exception e) {
            return null;
        }
    }

    private ArrayList<Reservation> processResults(String result) {
        ArrayList<Reservation> results = new ArrayList<>();
        String[] rows = result.split("\n");
        for(int i = 0; i < rows.length; i++){
            
            String[] cols = rows[i].split(",");
            String[] timeDate = cols[3].split(" ");
            
            Reservation r = new Reservation(cols[0], cols[1], cols[2], timeDate[0], timeDate[1], cols[4], cols[5]);
            results.add(r);
        }
        return results;
    }

    @WebMethod(operationName = "login")
    public int login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        try {
            String sqlCmd = "SELECT autokey FROM tttexample.users WHERE username = '" + username;
            sqlCmd += "' AND password = PASSWORD('" + password + "') AND isactive = 1;";
            String result = dao.retrieve(sqlCmd);
            if("ERROR".equals(result)) {
                return 0;
            } else {
                return Integer.parseInt(result);
            }
        } catch(Exception e) {
            System.out.println("Error is : " + e.getMessage());
            return -1;
        }
    }

    /**
     * Web service operation
     * @param username
     * @param password
     * @param name
     * @param surname
     * @return 
     */
    @WebMethod(operationName = "register")
    public String register(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "name") String name, @WebParam(name = "surname") String surname) {
        String sqlCmd = "";
        
        sqlCmd = "SELECT COUNT(*) FROM tttexample.users WHERE username = '" + username + "';";
        try {
            String result = "";
            result = dao.retrieve(sqlCmd);
            if(result.equals("0")) {
                sqlCmd = "INSERT INTO users VALUES (default, '";
                sqlCmd += name + "', '" + surname + "', '" + username + "', PASSWORD('";
                sqlCmd += password + "'), 1, default);";
                System.out.println(sqlCmd);
                try {
                    result = dao.insert(sqlCmd);
                    if(!"INSERTED 1 ROWS.".equals(result)) {
                        return "ERROR-INSERT";
                    } else {
                        sqlCmd = "SELECT autokey FROM tttexample.users WHERE username = '" + username;
                        sqlCmd += "' AND password = PASSWORD('" + password + "') AND isactive = 1;";

                        try {
                            result = dao.retrieve(sqlCmd);
                            return result;
                        } catch(Exception g) {
                            return "ERROR-RETRIEVE";
                        }
                    }
                } catch(Exception e) {
                    return "ERROR-DB";
                }
            } else {
                return "ERROR-REPEAT";
            }
        } catch(Exception u) {
            return "ERROR-DB";
        }        
    }
}
