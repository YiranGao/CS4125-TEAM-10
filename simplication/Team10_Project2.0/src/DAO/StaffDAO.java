
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
    
    private StaffBean staff;

    public void RegisterCusotmer(StaffBean StaffRegBean) {
        
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
    
    public StaffBean getCustomer(String username) {
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from customers");
 
            while(resultSet.next()) {
 
                if(username.equals(resultSet.getString("username"))) {
                    staff.setUserName(resultSet.getString("username"));
                    staff.setPassword(resultSet.getString("password"));
                    staff.setFirstName(resultSet.getString("firstname"));
                    staff.setSurName(resultSet.getString("lastname"));
                    staff.setPhoneNum(resultSet.getString("phone_number"));
                    staff.setEmailAddress(resultSet.getString("email"));
                    staff.setUserType(resultSet.getInt("usertype"));
                    staff.setFeedBackMark(resultSet.getInt("feedback_mark"));
                    staff.setRestaurantID(resultSet.getInt("restaurant_id"));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String authenticateUser(LoginBean loginBean) {
 
        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();
 
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        String usernameDB = "";
        String passwordDB = "";
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username,password from staff");
 
            while(resultSet.next()) {
                usernameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
 
                if(userName.equals(usernameDB) && password.equals(passwordDB))
                    return "SUCCESS";
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}