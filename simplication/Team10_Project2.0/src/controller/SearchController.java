package controller;

import DAO.BookingDAO;
import DAO.CustomerDAO;
import bean.BookingBean;
import bean.CustomerBean;
import bean.StaffBean;
import javax.swing.JOptionPane;
import view.ReservationBookingView;
import view.SearchView;

/**
 *
 * @author gtara
 */
public class SearchController {
    
    private StaffBean staff;
    private String SearchType, search;
    
    public SearchController(String searchType,StaffBean aStaff){
        SearchType = searchType;
        staff = aStaff;
        
        SearchView view = new SearchView(searchType,this);
        view.setVisible(true);
    }
    
    public void search(String aSearch) {
        search = aSearch;
        
        switch(SearchType) {
            case "update booking"  : updateBooking(); break;
            case "cancel booking"  : cancelBooking(); break;
            case "update staff"    : updateStaff(); break;
            case "delete staff"    : deleteStaff(); break;
            case "update customer" : updateCutomer(); break;
            case "delete customer" : deleteCutomer(); break;
        }
    }
    
    public void updateBooking() {
        
        BookingDAO bookingDAO = new BookingDAO();
        try{
            BookingBean booking = bookingDAO.getBooking(Integer.parseInt(search));
            
            if(booking == null) {
                JOptionPane.showMessageDialog(null, "The booking doesn't exist!");
            } else {
                BookingBean model = new BookingBean();
                ReservationBookingView view = new ReservationBookingView();
                JOptionPane.showMessageDialog(null, "Entering modify booking pa needs to change");
//                StaffBookingController controller = new StaffBookingController(model, view, customer, staff, true);
//                controller.initController();
            }
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "A reservation id has not been entered!");
        }
    }
    
    public void cancelBooking() {
        BookingDAO bookingDAO = new BookingDAO();
        try{
            BookingBean booking = bookingDAO.getBooking(Integer.parseInt(search));
            if(booking == null) {
                JOptionPane.showMessageDialog(null, "The booking doesn't exist!");
            } else {
                deleteBookingController delete = new deleteBookingController();
                delete.deleteBooking(booking);
            }
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "A reservation id has not been entered!");
        }
    }
    
    public void updateStaff() {
        JOptionPane.showMessageDialog(null, "Brings to Update Staff");
    }
    
    public void deleteStaff() {
        JOptionPane.showMessageDialog(null, "Brings to Delete Staff");
    }
    
    public void updateCutomer() {
        JOptionPane.showMessageDialog(null, "Brings to Update Customer");
    }
    
    public void deleteCutomer() {
        JOptionPane.showMessageDialog(null, "Brings to Delete Customer");
    }
}
