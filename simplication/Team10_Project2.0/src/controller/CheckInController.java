package controller;

import DAO.BookingDAO;
import bean.BookingBean;
import javax.swing.JOptionPane;

/**
 *
 * @author gtara
 */
public class CheckInController {
    
    private String result = "Check In Sucessfull\n\nWarning Alegies Include:\n\n";
    
    public void CheckIn(BookingBean booking) {
        
        int counter = 0;
        
        if(booking.getAllergyDairy() == 1) {
            result += "Dairy\n";
            counter++;
        }
        if(booking.getAllergyPeanuts() == 1) {
            result += "Peanuts\n";
            counter++;
        }
        if(booking.getAllergyGluten() == 1) {
            result += "Gluten\n";
            counter++;
        }
        if(booking.getAllergyFish() == 1) {
            result += "Fish\n";
            counter++;
        }
        if(booking.getAllergyShellfish() == 1) {
            result += "Shellfish\n";
            counter++;
        }
        if(booking.getAllergySoya() == 1) {
            result += "Soya\n";
            counter++;
        }
        if(counter == 0) {
            result += "No Alergies\n";
        }
        
        JOptionPane.showMessageDialog(null, result);
    }
    
    
}
