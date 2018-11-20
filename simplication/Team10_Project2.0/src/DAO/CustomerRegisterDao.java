package DAO;

import bean.CustomerBean;
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
public class CustomerRegisterDao {
    
    
    public boolean autheticateUserDetails(String username){

        
        Connection con;
        Statement statement;
        ResultSet resultSet;
 
        String usernameDB;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username from customers");
 
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

    public void RegisterCusotmer(CustomerBean CustRegBean) {
        
        Connection con;
        Statement statement;
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = ("insert into customers(username, password, firstname, lastname, phone_number, email, birthday, creditcard_id) values(?,?,?,?,?,?,?,null)");
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,CustRegBean.getUserName());
            ps.setString(2,CustRegBean.getPassword() );
            ps.setString(3,CustRegBean.getFirstName() );
            ps.setString(4,CustRegBean.getSurName() );
            ps.setString(5,CustRegBean.getPhoneNum() );
            ps.setString(6,CustRegBean.getEmailAddress() );
            ps.setString(7,CustRegBean.getDOB() );
            ps.executeUpdate();
            
            
        } catch(SQLException e) {
            System.out.print(e);
        }   
            
            
        }
}