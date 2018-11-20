package DAO;

import bean.bookingBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

public class reservationDAO {
    
        private int customerID;
        private int RestID;
        private int TableID;
        private int NoOfGuests;
        private String Date;
        private int AllergyDairy;
        private int AllergyFish;
        private int AllergyGluten;
        private int AllergyPeanuts;
        private int AllergyShellfish;
        private int AllergySoya;
        
        private bookingBean booking;
    

    public String createReservation(bookingBean bookingBean) {
 
        customerID = bookingBean.getCustomerID();
        RestID = bookingBean.getRestID();
        TableID = bookingBean.getTableID();
        NoOfGuests = bookingBean.getNoOfGuests();
        Date = bookingBean.getDate();
        AllergyDairy = bookingBean.getAllergyDairy();
        AllergyFish = bookingBean.getAllergyFish();
        AllergyGluten = bookingBean.getAllergyGluten();
        AllergyPeanuts = bookingBean.getAllergyPeanuts();
        AllergyShellfish = bookingBean.getAllergyShellfish();
        AllergySoya = bookingBean.getAllergySoya();
 
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = ("insert into reservations(reservation_id, customer_id, numofguests, bookingdate, table_id, restaurant_id, gluten_allergy, dairy_allergy, fish_allergy, shellfish_allergy, peanuts_allergy, soya_allergy) values(null,?,?,?,?,?,?,?,?,?,?,?)");
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,customerID);
            ps.setInt(2, NoOfGuests);
            ps.setString(3, Date);
            ps.setInt(4, TableID);
            ps.setInt(5, RestID);
            ps.setInt(6, AllergyGluten);
            ps.setInt(7, AllergyDairy);
            ps.setInt(8, AllergyFish);
            ps.setInt(9, AllergyShellfish);
            ps.setInt(10, AllergyPeanuts);
            ps.setInt(11, AllergySoya);
           
            ps.executeUpdate();
 
               // if(userName.equals(usernameDB) && password.equals(passwordDB))
                    return "SUCCESS";
            //}
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
    
    public bookingBean getReservation(int resID)
    {
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        int reservation_idDB = 0;
        int customerIDDB = 0;
        int numofGuestsDB = 0;
        String dateDB = "";
        int tableIDDB = 0;
        int restaurantIDDB = 0;
        int glutenAllergyDB = 0;
        int dairyAllergyDB = 0;
        int fishAllergyDB = 0;
        int shellfishAllergyDB = 0;
        int peanutAllergyDB = 0;
        int soyaAllergyDB = 0;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from reservations");
 
            while(resultSet.next()) {
                
                reservation_idDB = resultSet.getInt("reservation_id");
                customerIDDB = resultSet.getInt("customer_id");
                numofGuestsDB = resultSet.getInt("numofGuestsDB"); 
                dateDB = resultSet.getString("dateDB");
                tableIDDB = resultSet.getInt("tableIDDB");
                restaurantIDDB = resultSet.getInt("restaurantIDDB");
                glutenAllergyDB = resultSet.getInt("glutenAllergyDB");
                dairyAllergyDB = resultSet.getInt("dairyAllergyDB"); 
                fishAllergyDB = resultSet.getInt("fishAllergy");  
                shellfishAllergyDB = resultSet.getInt("shellfishAllergy");
                peanutAllergyDB = resultSet.getInt("peanutAllergyDB");
                soyaAllergyDB = resultSet.getInt("customer_id");        
 
                if(resID == reservation_idDB) {
                    booking.setReservationID(reservation_idDB);
                    booking.setCustomerID(customerIDDB);
                    booking.setRestID(restaurantIDDB);
                    booking.setTableID(tableIDDB);
                    booking.setNoOfGuests(numofGuestsDB);
                    booking.setDate(dateDB);
                    booking.setAllergyDairy(dairyAllergyDB);
                    booking.setAllergyFish(fishAllergyDB);
                    booking.setAllergyGluten(glutenAllergyDB);
                    booking.setAllergyPeanuts(peanutAllergyDB);
                    booking.setAllergyShellfish(shellfishAllergyDB);
                    booking.setAllergySoya(soyaAllergyDB);
                }
                    
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
}



