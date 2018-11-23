
package DAO;

import bean.TableBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author gtara
 */
public class TableDAO {
    
    private TableBean table = new TableBean();
    
    public String addTable(TableBean table) {
        
        int restaurantID = table.getRestaurantID();
        int tableState = table.getTableState();
        int seatAmount = table.getSeatAmount();
        
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = ("insert into tables(restaurant_id, table_state, seat_amount) values(?,?,?)");
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, restaurantID);
            ps.setInt(2, tableState);
            ps.setInt(3, seatAmount);
           
            ps.executeUpdate();
 
            return "SUCCESS";
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
    
    public TableBean getTable(int tableID) {
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from tables");
 
            while(resultSet.next()) {    
 
                if(tableID == resultSet.getInt("tables_id")) {
                    table.setTableID(resultSet.getInt("tables_id"));
                    table.setRestaurantID(resultSet.getInt("restaurant_id"));
                    table.setTableState(resultSet.getInt("table_state"));
                    table.setSeatAmount(resultSet.getInt("seat_amount"));
                    
                    return table;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
