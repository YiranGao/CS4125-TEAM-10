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
 * @author Gavin
 */
public class SearchController {
    
    private StaffBean staff;
    private SearchView view;
    private String SearchType, search;
    
    public SearchController(String searchType,StaffBean aStaff){
        SearchType = searchType;
        staff = aStaff;
        
        view = new SearchView(searchType,this);
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
            case "check in"        : checkIn();
        }
    }
    
    public void updateBooking() {
        
        BookingDAO bookingDAO = new BookingDAO();
        try{
            BookingBean booking = bookingDAO.getBooking(Integer.parseInt(search));
            
            if(booking == null) {
                JOptionPane.showMessageDialog(null, "The booking doesn't exist!");
            } else {
                ReservationBookingView bookingView = new ReservationBookingView();
                CustomerBean customer = new CustomerBean();
                CustomerDAO customerDAO = new CustomerDAO();
                customer = customerDAO.getCustomer(booking.getCustomerID());
                ModifyBookingController controller = new ModifyBookingController(booking, bookingView, customer, staff);
                view.dispose();
                controller.initController();
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
                DeleteBookingController delete = new DeleteBookingController();
                view.dispose();
                delete.deleteBooking(booking);
            }
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "A reservation id has not been entered!");
        }
    }
    
    public void updateStaff() {
        JOptionPane.showMessageDialog(null, "Brings to Update Staff");
        view.dispose();
    }
    
    public void deleteStaff() {
        JOptionPane.showMessageDialog(null, "Brings to Delete Staff");
        view.dispose();
    }
    
    public void updateCutomer() {
        JOptionPane.showMessageDialog(null, "Brings to Update Customer");
        view.dispose();
    }
    
    public void deleteCutomer() {
        JOptionPane.showMessageDialog(null, "Brings to Delete Customer");
        view.dispose();
    }
    
    public void checkIn() {
        BookingDAO bookingDAO = new BookingDAO();
        try{
            BookingBean booking = bookingDAO.getBooking(Integer.parseInt(search));
            if(booking == null) {
                JOptionPane.showMessageDialog(null, "The booking doesn't exist!");
            } else {
                CheckInController checkIn = new CheckInController();
                view.dispose();
                checkIn.CheckIn(booking);
            }
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "A reservation id has not been entered!");
        }
    }
}
