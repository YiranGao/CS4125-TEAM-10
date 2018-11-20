/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.creditcardBean;

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
public class creditcardDAO {
    
    private creditcardBean creditcard = new creditcardBean();
    
    public String addCreditcard(creditcardBean creditcard) {
        
        String holderName = creditcard.getHolderName();
        int year = creditcard.getYear();
        int month = creditcard.getMonth();
        String number = creditcard.getNumber();
        
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = ("insert into tables(holder_name, validdate_year, validdate_month, card_number) values(?,?,?,?)");
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, holderName);
            ps.setInt(2, year);
            ps.setInt(3, month);
            ps.setString(4, number);
           
            ps.executeUpdate();
 
            return "SUCCESS";
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
    
    public creditcardBean getCreditcard(int cardID) {
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        int card_idDB = 0;
        String holderNameDB = "";
        int yearDB = 0;
        int monthDB = 0;
        String numberDB = "";
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from tables");
 
            while(resultSet.next()) {
                
                card_idDB = resultSet.getInt("card_id");  
                holderNameDB = resultSet.getString("holder_name");
                yearDB = resultSet.getInt("validdate_year");
                monthDB = resultSet.getInt("validdate_month");
                numberDB = resultSet.getString("card_number");
 
                if(cardID == card_idDB) {
                    creditcard.setCardID(card_idDB);
                    creditcard.setHolderName(holderNameDB);
                    creditcard.setYear(yearDB);
                    creditcard.setMonth(monthDB);
                    creditcard.setNumber(numberDB);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
