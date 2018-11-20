package DAO;

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
    
    
    public static boolean autheticateUserDetails(String username){

        
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
}