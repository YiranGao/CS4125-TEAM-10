package controller;

import DAO.ReservationDAO;
import bean.bookingBean;
import javax.swing.JOptionPane;
import view.java_app.createReservation2;
//import view.java_app.mainmenu;

public class StaffBookingController {
    
    public StaffBookingController(String aUserName, String aRestID, String aTableID, String aNoOfGuests, String aDate, String aTime, int aAllergyDairy, int aAllergyFish, int aAllergyGluten, int aAllergyPeanuts, int aAllergyShellfish, int aAllergySoya, createReservation2 res) {
       
        bookingBean bookingBean = new bookingBean();
        
        bookingBean.setRestID(Integer.parseInt(aRestID));
        bookingBean.setTableID(Integer.parseInt(aTableID));
        bookingBean.setNoOfGuests(Integer.parseInt(aNoOfGuests));
        bookingBean.setDate(aDate);
        bookingBean.setAllergyDairy(aAllergyDairy);
        bookingBean.setAllergyFish(aAllergyFish);
        bookingBean.setAllergyGluten(aAllergyGluten);
        bookingBean.setAllergyPeanuts(aAllergyPeanuts);
        bookingBean.setAllergyShellfish(aAllergyShellfish);
        bookingBean.setAllergySoya(aAllergySoya);
        
        ReservationDAO bookingDao = new ReservationDAO();
        
        String userValidate = bookingDao.addReservation(bookingBean);
        
        if(userValidate.equals("SUCCESS")){
            JOptionPane.showMessageDialog(null,"Table has been reserved");
            res.closeRes();
            
        } else {
            JOptionPane.showMessageDialog(null,"Reservation Unsuccessfull");
        }
        
        
    }
    
}
