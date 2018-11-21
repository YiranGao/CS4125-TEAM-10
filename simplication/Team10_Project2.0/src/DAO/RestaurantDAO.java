
package DAO;

import bean.restaurantBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

public class RestaurantDAO {
        
    private restaurantBean restaurant;

    public String addRestaurant(restaurantBean restaurantBean) {
 
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "insert into restaurants(restaurant_id, name, locaiton, tableamount) values(?,?,?,?)";
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, restaurantBean.getRestaurant_id());
            ps.setString(2, restaurantBean.getName());
            ps.setString(3, restaurantBean.getLocation());
            ps.setInt(4, restaurantBean.getTableAmount());

           
            ps.executeUpdate();
 
               // if(userName.equals(usernameDB) && password.equals(passwordDB))
                    return "SUCCESS";
            //}
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
    
    public restaurantBean getRestaurant(int restID)
    {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from restaurants");
 
            while(resultSet.next()) {     
 
                if(restID == resultSet.getInt("restaurant_id")) {
                    restaurant.setRestaurant_id(resultSet.getInt("restaurant_id"));
                    restaurant.setName(resultSet.getString("name"));
                    restaurant.setLocation(resultSet.getString("location"));
                    restaurant.setTableAmount(resultSet.getInt("tableamount"));
                }
                    
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
}



