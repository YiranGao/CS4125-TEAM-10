
package controller;

import javax.swing.JOptionPane;

import DAO.StaffDAO;
import bean.StaffBean;
import view.LoginView;

/**
 *
 * @author Gavin
 */
public class LoginController {
    
    LoginView login;
    
    public LoginController() {
        
        login = new LoginView(this);
        login.setVisible(true);
    }
    
    public void submitLogin(String username, String password){
        
        StaffDAO loginDao = new StaffDAO();
        
        String userValidate = loginDao.authenticateLogin(username, password);
        
        if(userValidate.equals("SUCCESS")){
            StaffBean staff = new StaffBean();
            staff = loginDao.getStaff(username);
            login.closeLogin();
            MainmenuController mainmenu = new MainmenuController(staff);
        } else {
            JOptionPane.showMessageDialog(null,"Login Unsuccessfull");
        }
    }
}
