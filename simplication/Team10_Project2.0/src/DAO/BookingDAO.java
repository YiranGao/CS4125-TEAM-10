
package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.BookingBean;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import util.DBConnection;

public class BookingDAO {
        
    private BookingBean booking = new BookingBean();

    public String addBooking(BookingBean bookingBean) {
 
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "insert into reservations(customer_id, numofguests, bookingdate, table_id, restaurant_id, gluten_allergy, dairy_allergy,";
            sql += " fish_allergy, shellfish_allergy, peanuts_allergy, soya_allergy) values(?,?,?,?,?,?,?,?,?,?,?)";
            Timestamp timestamp;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date parsedDate = dateFormat.parse(bookingBean.getDate());
                //Date parsedDate = dateFormat.parse("2018-11-24 18:00:00");
                timestamp = new java.sql.Timestamp(parsedDate.getTime());
                
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, bookingBean.getCustomerID());
                System.out.println("-------------------- " + bookingBean.getCustomerID());
                ps.setInt(2, bookingBean.getNoOfGuests());
                //ps.setString(3, bookingBean.getDate());

                ps.setTimestamp(3, timestamp);

                ps.setInt(4, bookingBean.getTableID());
                ps.setInt(5, bookingBean.getRestID());
                ps.setInt(6, bookingBean.getAllergyGluten());
                ps.setInt(7, bookingBean.getAllergyDairy());
                ps.setInt(8, bookingBean.getAllergyFish());
                ps.setInt(9, bookingBean.getAllergyShellfish());
                ps.setInt(10, bookingBean.getAllergyPeanuts());
                ps.setInt(11, bookingBean.getAllergySoya());

                ps.executeUpdate();
                return "SUCCESS";
            } catch(Exception e) { //this generic but you can control nother types of exception
                    // look the origin of excption 
                                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            

 
               // if(userName.equals(usernameDB) && password.equals(passwordDB))
                    //return "SUCCESS";
            //}
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return "Invalid user credentials";
    }
    
    public BookingBean getBooking(int resID)
    {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from reservations");
 
            while(resultSet.next()) {     
 
                if(resID == resultSet.getInt("reservation_id")) {
                    booking.setReservationID(resultSet.getInt("reservation_id"));
                    booking.setCustomerID(resultSet.getInt("customer_id"));
                    booking.setNoOfGuests(resultSet.getInt("numofguests"));
                    booking.setDate(resultSet.getString("bookingdate"));
                    booking.setTableID(resultSet.getInt("table_id"));
                    booking.setRestID(resultSet.getInt("restaurant_id"));
                    booking.setAllergyGluten(resultSet.getInt("gluten_allergy"));
                    booking.setAllergyDairy(resultSet.getInt("dairy_allergy"));
                    booking.setAllergyFish(resultSet.getInt("fish_allergy"));
                    booking.setAllergyShellfish(resultSet.getInt("shellfish_allergy"));
                    booking.setAllergyPeanuts(resultSet.getInt("peanuts_allergy"));
                    booking.setAllergySoya(resultSet.getInt("soya_allergy"));
                    
                    return booking;
                }
                    
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
}



