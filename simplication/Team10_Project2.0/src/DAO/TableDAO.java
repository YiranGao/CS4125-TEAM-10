
package DAO;

import bean.TableBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import util.DBConnection;
import java.sql.Timestamp;
import java.text.ParseException;

/**
 *
 * @author Gavin
 */
public class TableDAO {
    
    private TableBean table = new TableBean();
    private Connection con;
    private Statement statement;
    private ResultSet resultSet;
    
    public String addTable(TableBean table) {
        
        int restaurantID = table.getRestaurantID();
        int tableState = table.getTableState();
        int seatAmount = table.getSeatAmount();
        
 
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
    
    
    public ArrayList<String> getFreeTables(int restaurantID, String datetime) {
        
        ArrayList<String> tableList = new ArrayList<String>();
        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(datetime);
            //Date parsedDate = dateFormat.parse("2018-11-24 18:00:00");
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "SELECT table_id, seat_amount from tables WHERE restaurant_id = ? AND table_id NOT IN";
            sql += "(SELECT tables.table_id FROM `tables` INNER JOIN `reservations` ON tables.table_id = reservations.table_id WHERE reservations.restaurant_id = ? AND reservations.bookingdate = ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, restaurantID);
            ps.setInt(2, restaurantID);
            ps.setTimestamp(3, timestamp);
            resultSet = ps.executeQuery(); //statement.executeQuery(ps);
            while(resultSet.next()) {    
                tableList.add(resultSet.getInt("table_id") + ", " + resultSet.getInt("seat_amount") + " seats");
            }
            return tableList;
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
