/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.tableBean;
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
public class tableDAO {
    
    private tableBean table = new tableBean();
    
    public String addTable(tableBean table) {
        
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
    
    public tableBean getTable(int tableID) {
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        int table_idBD = 0;
        int restaurant_idDB = 0;
        int tableStateDB = 0;
        int seatAmountDB = 0;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from tables");
 
            while(resultSet.next()) {
                
                table_idBD = resultSet.getInt("tables_id");  
                restaurant_idDB = resultSet.getInt("restaurant_id");
                tableStateDB = resultSet.getInt("table_state");
                seatAmountDB = resultSet.getInt("seat_amount");        
 
                if(tableID == table_idBD) {
                    table.setTableID(table_idBD);
                    table.setRestaurantID(restaurant_idDB);
                    table.setTableState(tableStateDB);
                    table.setSeatAmount(seatAmountDB);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
