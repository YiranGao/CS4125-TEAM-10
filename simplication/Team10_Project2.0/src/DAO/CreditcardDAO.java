
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
public class CreditcardDAO {
    
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
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from tables");
 
            while(resultSet.next()) {
 
                if(cardID == resultSet.getInt("card_id")) {
                    creditcard.setCardID(resultSet.getInt("card_id"));
                    creditcard.setHolderName(resultSet.getString("holder_name"));
                    creditcard.setYear(resultSet.getInt("validdate_year"));
                    creditcard.setMonth(resultSet.getInt("validdate_month"));
                    creditcard.setNumber(resultSet.getString("card_number"));
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
