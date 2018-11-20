package controller;

import DAO.createReservation2DAO;
import bean.bookingBean;
import javax.swing.JOptionPane;
import view.java_app.createReservation2;
//import view.java_app.mainmenu;

public class StaffBookingController {
    
    public StaffBookingController(String aRestName, String aTableID, String aNoOfGuests, String aDate, int aAllergyDairy, int aAllergyFish, int aAllergyGluten, int aAllergyPeanuts, int aAllergyShellfish, int aAllergySoya) {
       
        bookingBean bookingBean = new bookingBean();
        
        bookingBean.setRestName(aRestName);
        bookingBean.setTableID(aTableID);
        bookingBean.setNoOfGuests(aNoOfGuests);
        bookingBean.setDate(aDate);
        bookingBean.setAllergyDairy(aAllergyDairy);
        bookingBean.setAllergyFish(aAllergyFish);
        bookingBean.setAllergyGluten(aAllergyGluten);
        bookingBean.setAllergyPeanuts(aAllergyPeanuts);
        bookingBean.setAllergyShellfish(aAllergyShellfish);
        bookingBean.setAllergySoya(aAllergySoya);
        
         createReservation2DAO bookingDao = new createReservation2DAO();
        
        String userValidate = bookingDao.authenticateReservation(bookingBean);
        
        if(userValidate.equals("SUCCESS")){
            JOptionPane.showMessageDialog(null,"Table has been reserved");
        } else {
            JOptionPane.showMessageDialog(null,"Reservation Unsuccessfull");
        }
        
        
    }
    
}
