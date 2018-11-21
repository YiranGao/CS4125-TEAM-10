package controller;

import DAO.CustomerDAO;
import DAO.ReservationDAO;
import DAO.reservationDAO;
import bean.BookingBean;
import bean.CustomerBean;
import bean.bookingBean;
import javax.swing.JOptionPane;
import view.java_app.ReservationBooking;
import view.java_app.createReservation2;
//import view.java_app.mainmenu;

public class StaffBookingController {
    
    private BookingBean bookingBean; //model
    private ReservationBooking view;
    
    public StaffBookingController(BookingBean m, ReservationBooking v) {
        bookingBean = m;
        view = v;
    }
    
    
    public void initController() {
        view.getTableButton().addActionListener(e -> pickTable());
        view.getCancelButton().addActionListener(e -> cancel());
        view.getConfirmButton().addActionListener(e -> makeBooking());
    }
    
    
    private void makeBooking() {                                                     
        String userName = view.getUserNameTextField().getText();
        CustomerDAO customerDAO = new CustomerDAO();
        CustomerBean customer = customerDAO.getCustomer(userName);
        
        bookingBean.setCustID(customer.getUserID());
        bookingBean.setRestID(Integer.parseInt(view.getRestaurantIdLabel().getText()));
        bookingBean.setTableID(Integer.parseInt(view.getTableIDLabel().getText()));
        bookingBean.setNoOfGuests(Integer.parseInt(view.getNumOfGuestsTextField().getText()));
           
        String time = "18:00";
        String dateTime = view.getDateTextField().getText() + " " + time;
        bookingBean.setDate(dateTime);

        if(view.getAllergyDairy().isSelected())
        {
            bookingBean.setAllergyDiary(1);
        }
        if(view.getAllergyFish().isSelected())
        {
            bookingBean.setAllergyFish(1);
        }
        if(view.getAllergyGluten().isSelected())
        {
            bookingBean.setAllergyGluten(1);
        }
        if(view.getAllergyPeanuts().isSelected())
        {
            bookingBean.setAllergyPeanuts(1);
        }
        if(view.getAllergyShellfish().isSelected())
        {
            bookingBean.setAllergyShellfish(1);
        }
        if(view.getAllergySoya().isSelected())
        {
            bookingBean.setAllergySoya(1);
        }
        
        ReservationDAO reservationDAO = new ReservationDAO();
        String userValidate = reservationDAO.addReservation(bookingBean);
        
        if(userValidate.equals("SUCCESS")){
            JOptionPane.showMessageDialog(null,"Table has been reserved");
            view.dispose();
            
        } else {
            JOptionPane.showMessageDialog(null,"Reservation Unsuccessfull");
        }

    }  
    
    private void pickTable() {
        
    }
    
    private void cancel() {
        
    }
    
}
