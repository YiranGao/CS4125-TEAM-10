package controller;

import DAO.StaffDAO;
import bean.StaffBean;
import javax.swing.JOptionPane;

/**
 *
 * @author Sean
 */
public class StaffRegisterController {
    private final String userNamePattern = "^[A-Za-z0-9]+$";
    private final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String namePattern = "^[A-Za-z]+$";
    private final StaffBean staffRegBean = new StaffBean();
    
    //The authentication return is not returning the correct value yet
    public void checkUsername(String userName){
        StaffDAO authUser = new StaffDAO();
            
        if(authUser.autheticateUserDetails(userName)){//this needs to call the DAO and return true so we know that username isnt taken
            
            staffRegBean.setUserName(userName);
        }
        else{
            
            checkUsername(JOptionPane.showInputDialog(null,"The username: " + userName + " is taken please enter a new user name", JOptionPane.ERROR_MESSAGE));
            
        }
    }
    public void checkEmailAddress(String emailAddress){
            
            if(emailAddress.matches(emailPattern)){
                staffRegBean.setEmailAddress(emailAddress);
            }
            else{
                checkEmailAddress(JOptionPane.showInputDialog(null,"The Email Address: " + emailAddress + " is taken please enter a new user name", JOptionPane.ERROR_MESSAGE));
            }
        }
    public void checkFirstName(String FName){
            
            if(FName.matches(namePattern)){
                staffRegBean.setFirstName(FName);
            }
            else{
                checkFirstName(JOptionPane.showInputDialog(null,"Names cannot be Null and should not include numbers!", JOptionPane.ERROR_MESSAGE));
            }
        }
    public void checkSurName(String SName){
            
            if(SName.matches(namePattern)){
                staffRegBean.setSurName(SName);
            }
            else{
                checkSurName(JOptionPane.showInputDialog(null,"Names cannot be Null and should not include numbers!", JOptionPane.ERROR_MESSAGE));
            }
        }
    public void checkPW(String password){
            
            if(password.matches(userNamePattern)){
                 staffRegBean.setPassword(password);
            }
            else{
                checkPW(JOptionPane.showInputDialog(null,"The password must contain at least one upper and one lower /n case letter along with at least one number", JOptionPane.ERROR_MESSAGE));
            }  
        }
    public void checkPhoneNumber(String phoneNum){
            
            if(phoneNum.matches("^[0-9]+$") && phoneNum.length() <=12 && phoneNum.length() >= 9){
                staffRegBean.setPhoneNum(phoneNum);   
            }
            else{
                checkPhoneNumber(JOptionPane.showInputDialog(null,"A phone number should be numbers 0-9 and <=12 >=9", JOptionPane.ERROR_MESSAGE));
            }
        }
    public void RegisterCustomer(StaffBean staffRegBean){
            StaffDAO genStaff = new StaffDAO();
                   genStaff.RegisterStaff(staffRegBean);
            
        }
    public void addUserType(int staffUserType){
        
        staffRegBean.setUserType(staffUserType);
        
    }
    public void addResturantID(int resturantID){
        
        staffRegBean.setRestaurantID(resturantID);
    }
}
