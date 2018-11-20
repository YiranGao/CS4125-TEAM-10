package DAO;

import bean.CustomerBean;
import java.sql.Connection;
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
            
            
        }
}