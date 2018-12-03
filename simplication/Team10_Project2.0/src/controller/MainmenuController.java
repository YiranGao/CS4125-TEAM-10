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
 * @author Gavin
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
        view.getUserProfileButton().addActionListener(e-> goToUserProfile());
        view.getCreateReservationButton().addActionListener(e-> goToCreateBooking());
        view.getModifyReservationButton().addActionListener(e-> goToModifyBooking());
        view.getCancelReservationButton().addActionListener(e-> goToCancelBooking());
        view.getCreateCustomerButton().addActionListener(e-> goToCreateCustomer());
        view.getModifyCustomerButton().addActionListener(e-> goToModifyCustomer());
        view.getDeleteCustomerButton().addActionListener(e-> goToDeleteCustomer());
        view.getCreateStaffButton().addActionListener(e-> goToCreateCustomer());
        view.getModifyStaffButton().addActionListener(e-> goToModifyCustomer());
        view.getDeleteStaffButton().addActionListener(e-> goToDeleteCustomer());
        view.getCheckInButton().addActionListener(e-> goToCheckIn());
        view.getLogOutButton().addActionListener(e-> goToLogOut());
        view.getAddFeedbackButton().addActionListener(e-> goToFeedback());
    }
    
    public void goToUserProfile() {
        StaffProfileController staffProfile = new StaffProfileController(staff);
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
            CreateBookingController controller = new CreateBookingController(model, view, customer, staff);
            controller.initController();
        }
    }    
    
    public void goToModifyBooking() {
        SearchController search = new SearchController("update booking",staff);
    }
    
    public void goToCancelBooking() {
        SearchController search = new SearchController("cancel booking",staff);
    }
    
    public void goToCreateCustomer() {
        CustomerRegisterController register = new CustomerRegisterController();
    }
    
    public void goToModifyCustomer() {
        SearchController search = new SearchController("update customer",staff);
    }
    
    public void goToDeleteCustomer() {
        SearchController search = new SearchController("delete customer",staff);
        
    }
    
    public void goToCheckIn() {
        SearchController search = new SearchController("check in",staff);
    }
    
    public void goToLogOut() {
        LoginController login = new LoginController();
        JOptionPane.showMessageDialog(null, "System should check for bookings not checked in");
        view.dispose();
    }
    
    public void goToFeedback() {
        FeedbackController feedback = new FeedbackController(staff);
    }
}
