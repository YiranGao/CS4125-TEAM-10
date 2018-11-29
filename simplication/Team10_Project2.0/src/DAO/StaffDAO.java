
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.LoginBean;
import bean.StaffBean;
import util.DBConnection;

/**
 *
 * @author Sean
 */
public class StaffDAO {
    
    private StaffBean staff = new StaffBean();

    public void RegisterStaff(StaffBean StaffRegBean) {
        
        Connection con;
        Statement statement;
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "insert into staff(username, password, firstname, lastname, phone_number,";
            sql += "email, usertype, restaurant_id) values(?,?,?,?,?,?,?,?)";
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,StaffRegBean.getUserName());
            ps.setString(2,StaffRegBean.getPassword());
            ps.setString(3,StaffRegBean.getFirstName());
            ps.setString(4,StaffRegBean.getSurName());
            ps.setString(5,StaffRegBean.getPhoneNum());
            ps.setString(6,StaffRegBean.getEmailAddress());
            ps.setInt(7,StaffRegBean.getFeedBackMark());
            ps.setInt(8, StaffRegBean.getRestaurantID());
            ps.executeUpdate();
            
            
        } catch(SQLException e) {
            System.out.print(e);
        }   
    }
    
    public StaffBean getStaff(String username) {
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from staff");
 
            while(resultSet.next()) {
 
                if(username.equals(resultSet.getString("username"))) {
                    staff.setUserID(resultSet.getInt("staff_id"));
                    staff.setUserName(resultSet.getString("username"));
                    staff.setPassword(resultSet.getString("password"));
                    staff.setFirstName(resultSet.getString("firstname"));
                    staff.setSurName(resultSet.getString("surname"));
                    staff.setPhoneNum(resultSet.getString("phone_number"));
                    staff.setEmailAddress(resultSet.getString("email"));
                    staff.setUserType(resultSet.getInt("usertype"));
                    staff.setFeedBackMark(resultSet.getInt("feedback_mark"));
                    staff.setRestaurantID(resultSet.getInt("restaurant_id"));
                    
                    return staff;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String authenticateLogin(String username, String password) {
 
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username,password from staff");
 
            while(resultSet.next()) {
 
                if(username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password")))
                    return "SUCCESS";
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
    
    public boolean autheticateUserDetails(String username){
        
        Connection con;
        Statement statement;
        ResultSet resultSet;
        String checkUsername;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username from staff");
 
            while(resultSet.next()) {
                checkUsername = resultSet.getString("username");
 
                if(username.equals(checkUsername))
                    return true;
            }
        } catch(SQLException e) {
            return false;
        }   
       return false;
    }
}
