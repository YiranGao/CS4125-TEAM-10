/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;

import DAO.StaffDAO;
import bean.LoginBean;
import bean.StaffBean;
import view.LoginView;

/**
 *
 * @author gtara
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
