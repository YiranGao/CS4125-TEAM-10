package DAO;

import bean.CustomerBean;
import bean.LoginBean;
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
public class CustomerDAO {
    
    private CustomerBean customer;

    public void addCusotmer(CustomerBean CustRegBean) {
        
        Connection con;
        Statement statement;
        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "insert into customers(username, password, firstname, lastname, phone_number,";
            sql += " email, birthday, creditcard_id) values(?,?,?,?,?,?,?,null)";
           
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
    
    public CustomerBean getCustomer(String username) {
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from customers");
 
            while(resultSet.next()) {
 
                if(username.equals(resultSet.getString("username"))) {
                    customer.setUserName(resultSet.getString("username"));
                    customer.setPassword(resultSet.getString("password"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setSurName(resultSet.getString("lastname"));
                    customer.setPhoneNum(resultSet.getString("phone_number"));
                    customer.setEmailAddress(resultSet.getString("email"));
                    customer.setDOB(resultSet.getString("birthday"));
                    customer.setCC(resultSet.getString("creditcard_id"));
                    customer.setLoyaltyPoints(resultSet.getInt("loyalty_points"));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean autheticateUserDetails(String username){
        
        Connection con;
        Statement statement;
        ResultSet resultSet;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username from customers");
 
            while(resultSet.next()) {
                username = resultSet.getString(username);
 
                if(username.equals("username"))
                    return false;
            }
        } catch(SQLException e) {
            return true;
        }   
       return true;
    }
}