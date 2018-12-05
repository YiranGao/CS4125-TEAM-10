package controller;

import DAO.BookingDAO;
import DAO.CustomerDAO;
import bean.BookingBean;
import bean.CustomerBean;
import bean.StaffBean;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import view.ReservationBookingView;

/**
 *
 * @author Patryk
 */
public class ModifyBookingController extends BookingController{
    
            
    public ModifyBookingController(BookingBean m, ReservationBookingView v, CustomerBean c, StaffBean s) {
        super(m,v,c,s);
        initReservation();
    }


    public void initReservation() {
        getView().getNumOfGuestsTextField().setText(Integer.toString(getBookingBean().getNoOfGuests())); // sets num of guests
        setTable(getBookingBean().getTableID()); // sets table
        setAllergies(); // sets allergies
        String timestamp = getBookingBean().getDate();
        String [] array = timestamp.split(" ");
        setTime(array[1]); // sets time
        getView().getTimeLabel().setText(getTime());
        getView().getTableLabel().setText(Integer.toString(getTable()));
        try {
            getView().getjDateChooser().setDate(getDf().parse(array[0])); // sets date
        } catch (ParseException ex) {
            Logger.getLogger(ModifyBookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void setAllergies() {
        
        if(getBookingBean().getAllergyDairy() > 0) {
            
            getView().getAllergyDairy().setSelected(true);
        }
        if(getBookingBean().getAllergyFish() > 0) {
            
            getView().getAllergyFish().setSelected(true);
        }
        if(getBookingBean().getAllergyGluten() > 0) {
            
            getView().getAllergyGluten().setSelected(true);
        }
        if(getBookingBean().getAllergyPeanuts() > 0) {
            
            getView().getAllergyPeanuts().setSelected(true);
        }
        if(getBookingBean().getAllergyShellfish() > 0) {
            
            getView().getAllergyShellfish().setSelected(true);
        }
        if(getBookingBean().getAllergySoya() > 0) {
            
            getView().getAllergySoya().setSelected(true);
        }
        
        
    }
        
        
        
    @Override
    void connectToDAO() {
        BookingDAO bookingDAO = new BookingDAO();
        String userValidate = bookingDAO.updateBooking(getBookingBean());
        if(userValidate.equals("SUCCESS")){
            JOptionPane.showMessageDialog(null,"Reservtion has been updated");
            getView().dispose();
        } else {
            JOptionPane.showMessageDialog(null,"Couldn't update thereservation");
        }
    }
    
}
