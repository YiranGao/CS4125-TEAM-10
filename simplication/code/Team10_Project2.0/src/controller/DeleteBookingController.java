package controller;

/**
 *
 * @author mjs-laptop
 */
import DAO.BookingDAO;
import DAO.CustomerDAO;
import bean.BookingBean;
import bean.CustomerBean;
import javax.swing.JOptionPane;


public class DeleteBookingController {
    public void deleteBooking(BookingBean booking)
    {
        CustomerBean cust1 = new CustomerBean();
        CustomerDAO custDAO = new CustomerDAO();
        BookingDAO bookingDAO = new BookingDAO();
        
        cust1 = custDAO.getCustomer(booking.getCustomerID());
        
        int loyaltyPoints = cust1.getLoyaltyPoints();

            
        int baseLineCalcualtionFee = 10;
        
        int cancellationFee = (baseLineCalcualtionFee * ((100 - loyaltyPoints)/100));
        
        if(loyaltyPoints >= 1000)
        {
            cancellationFee = 0;
        }
        
        loyaltyPoints -= 50;
        custDAO.updateLoyaltyPoints(loyaltyPoints, cust1.getUserID());
        String message = bookingDAO.deleteBooking(booking);
        JOptionPane.showMessageDialog(null, "CustomerID: " + cust1.getUserName() + "has cancelled a booking, loyalty points has been decremented. \n Cancellation Fee: " + cancellationFee + "\n" + message);

        
        
    }
}
