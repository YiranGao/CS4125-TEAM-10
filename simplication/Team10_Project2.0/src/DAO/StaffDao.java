package DAO;

import bean.CustomerBean;
import bean.StaffBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author Sean
 */
public class StaffDao {
     public boolean autheticateUserDetails(String username){

        
        Connection con;
        Statement statement;
        ResultSet resultSet;
 
        String usernameDB;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username from staff");
 
            while(resultSet.next()) {
                usernameDB = resultSet.getString(username);
 
                if(username.equals(usernameDB))
                    return false;
            }
        } catch(SQLException e) {
            return true;
        }   
       return true;
    }

    public void RegisterCusotmer(StaffBean StaffRegBean) {
        
        Connection con;
        Statement statement;
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = ("insert into staff(username, password, firstname, lastname, phone_number, email, usertype, restaurant_id) values(?,?,?,?,?,?,?,?)");
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,StaffRegBean.getUserName());
            ps.setString(2,StaffRegBean.getPassword());
            ps.setString(3,StaffRegBean.getFirstName());
            ps.setString(4,StaffRegBean.getSurName());
            ps.setString(5,StaffRegBean.getPhoneNum());
            ps.setString(6,StaffRegBean.getEmailAddress());
            ps.setInt(7,StaffRegBean.getStaffFeedBackMark());
            ps.setInt(7, StaffRegBean.getRestaurantID());
            ps.executeUpdate();
            
            
        } catch(SQLException e) {
            System.out.print(e);
        }   
            
            
        }
}
