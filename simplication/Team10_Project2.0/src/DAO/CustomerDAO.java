package DAO;

import bean.CustomerBean;
import bean.LoginBean;
import bean.StaffBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import util.DBConnection;

/**
 *
 * @author Sean
 */
public class CustomerDAO {
    
    private CustomerBean customer = new CustomerBean();
    private Connection con;
    private Statement statement;
    private ResultSet resultSet;

    public void addCusotmer(CustomerBean CustRegBean) {
        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "insert into customers(username, password, firstname, lastname, phone_number,";
            sql += " email, birthday, creditcard_id) values(?,?,?,?,?,?,?,?)";
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,CustRegBean.getUserName());
            ps.setString(2,CustRegBean.getPassword() );
            ps.setString(3,CustRegBean.getFirstName() );
            ps.setString(4,CustRegBean.getSurName() );
            ps.setString(5,CustRegBean.getPhoneNum() );
            ps.setString(6,CustRegBean.getEmailAddress() );
            ps.setString(7,CustRegBean.getDOB());
            ps.setInt(8,CustRegBean.getCC());
            ps.executeUpdate();
            
        } catch(SQLException e) {
            System.out.print(e);
        }   
    }
    
    public CustomerBean getCustomer(String username) {
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from customers");
            String stringCardID;
            while(resultSet.next()) {
 
                if(username.equals(resultSet.getString("username"))) {
                    customer.setUserID(resultSet.getInt("customer_id"));
                    customer.setUserName(resultSet.getString("username"));
                    customer.setPassword(resultSet.getString("password"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setSurName(resultSet.getString("lastname"));
                    customer.setPhoneNum(resultSet.getString("phone_number"));
                    customer.setEmailAddress(resultSet.getString("email"));
                    customer.setDOB(resultSet.getString("birthday"));
                    customer.setCC(resultSet.getInt("creditcard_id"));
                    customer.setLoyaltyPoints(resultSet.getInt("loyalty_points"));
                    
                    String name = customer.getFirstName();
                    
                    return customer;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
        public CustomerBean getCustomer(int cID) {
            String stringCardID;
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from customers");
 
            while(resultSet.next()) {
 
                if(cID == resultSet.getInt("customer_id")) {
                    customer.setUserID(resultSet.getInt("customer_id"));
                    customer.setUserName(resultSet.getString("username"));
                    customer.setPassword(resultSet.getString("password"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setSurName(resultSet.getString("lastname"));
                    customer.setPhoneNum(resultSet.getString("phone_number"));
                    customer.setEmailAddress(resultSet.getString("email"));
                    customer.setDOB(resultSet.getString("birthday"));
                    customer.setCC(resultSet.getInt("creditcard_id"));
                    customer.setLoyaltyPoints(resultSet.getInt("loyalty_points"));
                    
                    String name = customer.getFirstName();
                    
                    return customer;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        
        
         public void updateCustomer(CustomerBean customer) {
        
        Connection con;
        Statement statement;
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "UPDATE customers SET username = ? , password = ?, firstname = ?, lastname = ?, phone_number = ?,";
            sql += "email = ?, birthday = ?, creditcard_id = ? where username = ?";
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,customer.getUserName());
            ps.setString(2,customer.getPassword());
            ps.setString(3,customer.getFirstName());
            ps.setString(4,customer.getSurName());
            ps.setString(5,customer.getPhoneNum());
            ps.setString(6,customer.getEmailAddress());
            ps.setString(7,customer.getDOB());
            ps.setInt(8, customer.getCC());
            ps.setString(8, customer.getUserName());
            ps.executeUpdate();
            
            
        } catch(SQLException e) {
            System.out.print(e);
        }   
    }    
    
    public boolean autheticateUserDetails(String username){
        String checkUsername;
        
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username from customers");
 
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
    
    public void updateLoyaltyPoints(int points, int userID) {
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "UPDATE `customers` SET `loyalty_points` = ? WHERE `customer_id` = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, points);
            ps.setInt(2, userID);
            ps.executeUpdate();
            
        } catch(SQLException e) {
            System.out.print(e);
        }
    }
}