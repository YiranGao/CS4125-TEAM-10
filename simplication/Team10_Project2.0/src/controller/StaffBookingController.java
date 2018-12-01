package controller;

import DAO.CustomerDAO;
import DAO.BookingDAO;
import DAO.RestaurantDAO;
import DAO.TableDAO;
import bean.CustomerBean;
import bean.BookingBean;
import bean.StaffBean;
import bean.UserBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import view.ReservationBookingView;
//import view.java_app.createReservation2;
//import view.java_app.mainmenu;
public class StaffBookingController {
    
    private BookingBean bookingBean; //model
    private ReservationBookingView view;
    private CustomerBean customer;
    private StaffBean staff;
    private int loyaltyPoints = 100;
    
    public StaffBookingController(BookingBean m, ReservationBookingView v, CustomerBean c, StaffBean s) {
        bookingBean = m;
        view = v;
        customer = c;
        staff = s;
        initLabels();
        initTableList();
        view.setVisible(true);
    }
    
    public void initLabels() {
        RestaurantDAO rDao = new RestaurantDAO();
        view.getRestaurantLabel().setText(rDao.getRestaurant(staff.getRestaurantID()).getName());
        view.getLoyaltyLabel().setText(Integer.toString(customer.getLoyaltyPoints()));
        view.getNameLabel().setText(customer.getFirstName() + " " + customer.getSurName());
        view.getUserNameLabel().setText(customer.getUserName());
        view.getEmailLabel().setText(customer.getEmailAddress());
        view.getCardNumLabel().setText(customer.getCC());
        view.getPhoneNumLabel().setText(customer.getPhoneNum());
        
    }
    
    public void initController() {
        view.getTableButton().addActionListener(e -> pickTable());
        view.getCancelButton().addActionListener(e -> cancel());
        view.getConfirmButton().addActionListener(e -> makeBooking());
    }
    
    public void initTableList() {
        if(view.getjDateChooser().getDate() != null) {
            TableDAO tDao = new TableDAO();
            String time = "17:00";
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ArrayList<String> list = tDao.getFreeTables(staff.getRestaurantID(), df.format(view.getjDateChooser().getDate()) + " " + time + ":00");
            //String [] labels = {"1, 5 seats", "2, 4 seats"};
            String [] tables = new String[list.size()] ;
            tables = list.toArray(tables);
            // Fill model
            DefaultListModel model = new DefaultListModel();
            for (int i = 0, n = tables.length; i < n; i++) {
                model.addElement(tables[i]);
            }
            view.getTableList().setModel(model);
        }
    }
    
    
    private void makeBooking() {                                                     
        bookingBean.setCustomerID(customer.getUserID());
        setBookingValues();
        boolean validDate = validDate();
        if(validDate){
            String time = "18:00";
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dateTime = df.format(view.getjDateChooser().getDate()) + " " + time + ":00";
            bookingBean.setDate(dateTime);
            checkAllergies();
            BookingDAO bookingDAO = new BookingDAO();
            String userValidate = bookingDAO.addBooking(bookingBean);

            if(userValidate.equals("SUCCESS")){
                JOptionPane.showMessageDialog(null,"Table has been reserved");
                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.updateLoyaltyPoints(customer.getLoyaltyPoints() + loyaltyPoints, customer.getUserID());
                view.dispose();

            } else {
                JOptionPane.showMessageDialog(null,"Reservation Unsuccessfull");
            }
    }

    }  
    
    private void pickTable() {
        
    }
    
    private void setBookingValues() {
        bookingBean.setRestID(1); //(Integer.parseInt(view.getRestaurantIdLabel().getText()));
        bookingBean.setTableID(1); //(Integer.parseInt(view.getTableIDLabel().getText()));
        bookingBean.setNoOfGuests(Integer.parseInt(view.getNumOfGuestsTextField().getText()));
    }
    
    private boolean validDate() {
        boolean validDate = true;
        Date todayDate = new Date();
        if(todayDate.after(view.getjDateChooser().getDate())) {
            JOptionPane.showMessageDialog(null, "Please choose a valid date!");
            validDate = false;
        }
        return validDate;
    }
    
    public void checkAllergies() {
        if(view.getAllergyDairy().isSelected())
        {
            bookingBean.setAllergyDairy(1);
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
    }
    
    private void cancel() {
        view.dispose();
    }
    
}
