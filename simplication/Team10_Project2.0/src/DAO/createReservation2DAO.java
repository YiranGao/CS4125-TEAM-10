package DAO;

import bean.bookingBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

public class createReservation2DAO {

    public String authenticateReservation(bookingBean bookingBean) {
 
        String RestName = bookingBean.getRestName();
        String TableID = bookingBean.getTableID();
        String NoOfGuests = bookingBean.getNoOfGuests();
        String Date = bookingBean.getDate();
        int AllergyDairy = bookingBean.getAllergyDairy();
        int AllergyFish = bookingBean.getAllergyFish();
        int AllergyGluten = bookingBean.getAllergyGluten();
        int AllergyPeanuts = bookingBean.getAllergyPeanuts();
        int AllergyShellfish = bookingBean.getAllergyShellfish();
        int AllergySoya = bookingBean.getAllergySoya();
 
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = ("insert into reservations(numofguests, bookingdate, table_id, restaurant_id, gluten_allergy, dairy_allergy, fish_allergy, shellfish_allergy, peanuts_allergy, soya_allergy) values(?,?,?,?,?,?,?,?,?,?,?)");
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(4, RestName);
            ps.setString(3, TableID);
            ps.setString(1, NoOfGuests);
            ps.setString(2, Date);
            ps.setInt(6, AllergyDairy);
            ps.setInt(7, AllergyFish);
            ps.setInt(5, AllergyGluten);
            ps.setInt(9, AllergyPeanuts);
            ps.setInt(8, AllergyShellfish);
            ps.setInt(10, AllergySoya);
           
            ps.executeUpdate();
 
               // if(userName.equals(usernameDB) && password.equals(passwordDB))
                    return "SUCCESS";
            //}
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
    
}



