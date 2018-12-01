package controller;

import javax.swing.JOptionPane;
import view.SearchView;

/**
 *
 * @author gtara
 */
public class SearchController {
    
    String SearchType, search;
    
    public SearchController(String searchType){
        SearchType = searchType;
        
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
        JOptionPane.showMessageDialog(null, "Brings to Update Booking");
    }
    
    public void cancelBooking() {
        JOptionPane.showMessageDialog(null, "Brings to Cancel Booking");
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
