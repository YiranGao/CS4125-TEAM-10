package controller;

import DAO.CustomerDAO;
import bean.BookingBean;
import bean.CustomerBean;
import bean.StaffBean;
import javax.swing.JOptionPane;
import view.MainmenuView;
import view.ReservationBookingView;

/**
 *
 * @author gtara
 */
public class MainmenuController {
    
    private StaffBean staff;
    private MainmenuView view;
    
    public MainmenuController(StaffBean aStaffMember) {
        staff = aStaffMember;
        view = new MainmenuView(staff);
        initController();
    }
    
    public void initController() {
        view.getCreateReservationButton().addActionListener(e-> goToCreateBooking());
        view.getModifyReservationButton().addActionListener(e-> goToModifyBooking());
        view.getCancelReservationButton().addActionListener(e-> goToCancelBooking());
    }
    
    public void goToCreateBooking(){
        String username = JOptionPane.showInputDialog("Please enter the username of the customer: ");
        CustomerDAO customerDAO = new CustomerDAO();
        CustomerBean customer = customerDAO.getCustomer(username);
        if(customer == null) {
            JOptionPane.showMessageDialog(null, "The customer with the following username doesn't exist!");
        }
        else {
            BookingBean model = new BookingBean();
            ReservationBookingView view = new ReservationBookingView();
            StaffBookingController controller = new StaffBookingController(model, view, customer, staff, false);
            controller.initController();
        }
    }    
    
    public void goToModifyBooking() {
        
    }
    
    public void goToCancelBooking() {
        
    }
}
