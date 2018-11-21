
package DAO;

import bean.bookingBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

public class ReservationDAO {
        
    private bookingBean booking;

    public String addReservation(bookingBean bookingBean) {
 
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "insert into reservations(customer_id, numofguests, bookingdate, table_id, restaurant_id, gluten_allergy, dairy_allergy,";
            sql += " fish_allergy, shellfish_allergy, peanuts_allergy, soya_allergy) values(?,?,?,?,?,?,?,?,?,?,?)";
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookingBean.getCustomerID());
            ps.setInt(2, bookingBean.getNoOfGuests());
            ps.setString(3, bookingBean.getDate());
            ps.setInt(4, bookingBean.getTableID());
            ps.setInt(5, bookingBean.getRestID());
            ps.setInt(6, bookingBean.getAllergyGluten());
            ps.setInt(7, bookingBean.getAllergyDairy());
            ps.setInt(8, bookingBean.getAllergyFish());
            ps.setInt(9, bookingBean.getAllergyShellfish());
            ps.setInt(10, bookingBean.getAllergyPeanuts());
            ps.setInt(11, bookingBean.getAllergySoya());
           
            ps.executeUpdate();
 
               // if(userName.equals(usernameDB) && password.equals(passwordDB))
                    return "SUCCESS";
            //}
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
    
    public bookingBean getReservation(int resID)
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
                }
                    
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
}



