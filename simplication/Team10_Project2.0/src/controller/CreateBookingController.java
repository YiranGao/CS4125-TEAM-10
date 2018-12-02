package controller;

import DAO.BookingDAO;
import DAO.CustomerDAO;
import DAO.RestaurantDAO;
import Discount.Deals;
import Discount.SimpleDealsFactory;
import bean.BookingBean;
import bean.CustomerBean;
import bean.RestaurantBean;
import bean.StaffBean;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import view.ReservationBookingView;

/**
 *
 * @author Patryk
 */
public class CreateBookingController extends BookingController{
    private int loyaltyPoints = 100;

    public CreateBookingController(BookingBean m, ReservationBookingView v, CustomerBean c, StaffBean s) {
        super(m,v,c,s);
    }
    
    @Override
    void connectToDAO() {
        BookingDAO bookingDAO = new BookingDAO();
        applyDiscount();
        String userValidate = bookingDAO.addBooking(getBookingBean());
        if(userValidate.equals("SUCCESS")){
            JOptionPane.showMessageDialog(null,"Table has been reserved");
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.updateLoyaltyPoints(getCustomer().getLoyaltyPoints() + loyaltyPoints, getCustomer().getUserID());
            getView().dispose();
        } else {
            JOptionPane.showMessageDialog(null,"Reservation Unsuccessfull");
        }
    }
    
    protected void applyDiscount() {
        SimpleDealsFactory factory = new SimpleDealsFactory();
        RestaurantDAO rDAO = new RestaurantDAO();
        RestaurantBean r = rDAO.getRestaurant(getStaff().getRestaurantID());
        Deals deals = factory.createDeals(r.getName());
        double rate = deals.applyDiscount(getBookingBean().getDate(), getCustomer().getLoyaltyPoints());
        getBookingBean().setDiscount(rate);
    }
         
        
}
