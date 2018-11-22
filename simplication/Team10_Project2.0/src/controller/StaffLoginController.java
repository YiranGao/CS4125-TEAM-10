/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;

import DAO.StaffLoginDao;
import bean.LoginBean;
import view.Login;
import view.MainMenuView;

/**
 *
 * @author gtara
 */
public class StaffLoginController {
    
    public StaffLoginController(String aUsername, String aPassword, Login login) {
        
        LoginBean loginBean = new LoginBean();
        
        loginBean.setUserName(aUsername);
        loginBean.setPassword(aPassword);
        
        StaffLoginDao loginDao = new StaffLoginDao();
        
        String userValidate = loginDao.authenticateUser(loginBean);
        
        if(userValidate.equals("SUCCESS")){
            MainMenuView m = new MainMenuView();
            login.closeLogin();
            m.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,"Login Unsuccessfull");
        }
    }
}
