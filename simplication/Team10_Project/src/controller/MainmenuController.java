package controller;

import bean.StaffBean;
import view.MainmenuView;

/**
 *
 * @author gtara
 */
public class MainmenuController {
    
    private StaffBean staff;
    
    public MainmenuController(StaffBean aStaffMember) {
        staff = aStaffMember;
        MainmenuView mainmenu = new MainmenuView(staff);
        mainmenu.setVisible(true);
    }
    
    public void goToCreateBooking(){
        
    }
    
    public void goToModifyBooking() {
        
    }
}
