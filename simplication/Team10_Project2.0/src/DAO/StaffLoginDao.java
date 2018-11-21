
package DAO;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.LoginBean;
import util.DBConnection;


public class StaffLoginDao {
     
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