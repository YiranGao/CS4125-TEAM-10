package controller;

/**
 *
 * @author mjs-laptop
 */
import DAO.StaffDAO;
import bean.StaffBean;
import view.StaffProfileView;

public class StaffProfileController {
    
    StaffProfileView staffProfile;
    
    public StaffProfileController(StaffBean staff) {
        
        staffProfile = new StaffProfileView(staff);
        staffProfile.setVisible(true);
    }
}
