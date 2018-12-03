package controller;

import DAO.BookingDAO;
import DAO.CustomerDAO;
import DAO.RestaurantDAO;
import DAO.TableDAO;
import bean.BookingBean;
import bean.CustomerBean;
import bean.StaffBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import view.ReservationBookingView;

/**
 *
 * @author Patryk
 */
public abstract class BookingController {


    private BookingBean bookingBean; //model
    private ReservationBookingView view;
    private CustomerBean customer;
    private StaffBean staff;
    private String time = "";
    private int table = 0;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");


    public BookingController(BookingBean m, ReservationBookingView v, CustomerBean c, StaffBean s) {
        bookingBean = m;
        view = v;
        customer = c;
        staff = s;
        initLabels();
        view.setVisible(true);

    }

    private void initLabels() {
        RestaurantDAO rDao = new RestaurantDAO();
        view.getRestaurantLabel().setText(rDao.getRestaurant(getStaff().getRestaurantID()).getName());
        view.getLoyaltyLabel().setText(Integer.toString(getCustomer().getLoyaltyPoints()));
        view.getNameLabel().setText(getCustomer().getFirstName() + " " + getCustomer().getSurName());
        view.getUserNameLabel().setText(getCustomer().getUserName());
        view.getEmailLabel().setText(getCustomer().getEmailAddress());
        String cardID = Integer.toString(customer.getCC());
        view.getCardNumLabel().setText(cardID);
        view.getPhoneNumLabel().setText(getCustomer().getPhoneNum());
    }

    public void initController() {
        view.getCancelButton().addActionListener(e -> cancel());
        view.getConfirmButton().addActionListener(e -> makeBooking());
        view.getTableButton().addActionListener(e-> initTableList());
        view.getTimeslotList().addListSelectionListener(e -> timeSelected(e));
        view.getTableList().addListSelectionListener(e-> tableSelected(e));
    }

    public void initTableList() {
        if(view.getjDateChooser().getDate() != null && time != "") {
            TableDAO tDao = new TableDAO();
            ArrayList<String> list = tDao.getFreeTables(staff.getRestaurantID(), df.format(getView().getjDateChooser().getDate()) + " " + time + ":00");
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
        else {
            view.getTableList().setModel(new DefaultListModel());
        }
    }
    
    private void timeSelected(ListSelectionEvent ev){
        time = String.valueOf(((JList)ev.getSource()).getSelectedValue());
    }
    
    private void tableSelected(ListSelectionEvent ev){
        String line = String.valueOf(((JList)ev.getSource()).getSelectedValue());
        String [] array = line.split(", ");
        String [] array2 = array[1].split(" ");
        if(view.getNumOfGuestsTextField().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide the number of guests");
        }
        else if(Integer.parseInt(array2[0]) < Integer.parseInt(view.getNumOfGuestsTextField().getText())){
            JOptionPane.showMessageDialog(null, "There is not enough seats at this table");
        } else {
            table = Integer.parseInt(array[0]);
        }
    }
    
    private void makeBooking() {
        bookingBean.setCustomerID(customer.getUserID());
        setBookingValues();
        boolean validDate = validDate();
        if(validDate){
//            String time = "18:00";
            String dateTime = df.format(view.getjDateChooser().getDate()) + " " + time + ":00";
            bookingBean.setDate(dateTime);
            checkAllergies();
            connectToDAO();
            }
    }
    
    abstract void connectToDAO();

    
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
    
    private void setBookingValues() {
        bookingBean.setRestID(staff.getRestaurantID()); //(Integer.parseInt(view.getRestaurantIdLabel().getText()));
        bookingBean.setTableID(table); //(Integer.parseInt(view.getTableIDLabel().getText()));
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
    
    private void cancel() {
        view.dispose();
    }    
    
        
    // getters and setters    

    /**
     * @return the table
     */
    public int getTable() {
        return table;
    }
    
    public void setTable(int t) {
        table = t;
    }
    
        /**
     * @return the bookingBean
     */
    public BookingBean getBookingBean() {
        return bookingBean;
    }

    /**
     * @return the view
     */
    public ReservationBookingView getView() {
        return view;
    }

    /**
     * @return the customer
     */
    public CustomerBean getCustomer() {
        return customer;
    }

    /**
     * @return the staff
     */
    public StaffBean getStaff() {
        return staff;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }
    
    public void setTime(String t) {
        time = t;
    }

    /**
     * @return the df
     */
    public DateFormat getDf() {
        return df;
    }
}
