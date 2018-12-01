package controller;

/**
 *
 * @author mjs-laptop
 */
import DAO.StaffDAO;
import bean.StaffBean;
import view.StaffProfileView;

public class staffProfileController {
    
    StaffProfileView staffProfile;
    
    public staffProfileController(StaffBean staff) {
        
        staffProfile = new StaffProfileView(staff);
        staffProfile.setVisible(true);
    }
     
    
    public void displayStaffInfo(StaffBean staffMember)
    {
        
             
        
    }
}
