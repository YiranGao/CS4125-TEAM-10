
package DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.CreditcardBean;
import util.DBConnection;

/**
 *
 * @author gtara
 */
public class CreditcardDAO {
    
    private CreditcardBean creditcard = new CreditcardBean();
    
    public void addCreditcard(CreditcardBean creditcard) {
        
        String holderName = creditcard.getHolderName();
        int year = creditcard.getYear();
        int month = creditcard.getMonth();
        String number = creditcard.getNumber();
        
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = ("insert into creditcards(holder_name, validdate_year, validdate_month, card_number) values(?,?,?,?)");
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, holderName);
            ps.setInt(2, year);
            ps.setInt(3, month);
            ps.setString(4, number);
           
            ps.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public CreditcardBean getCreditcard(int cardID) {
        
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
                    
                    return creditcard;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    public int getCardID(int cardNumber){
        
    
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int cardID;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select card_id from creditcards");
 
            while(resultSet.next()) {
 
                if(cardNumber == resultSet.getInt("card_id")) {
                    cardID = resultSet.getInt("card_id");
                    return cardID;
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
