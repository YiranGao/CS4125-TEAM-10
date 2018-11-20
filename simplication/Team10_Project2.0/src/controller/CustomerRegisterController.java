package controller;

import DAO.CustomerRegisterDao;
import bean.CustomerBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Sean
 */
public class CustomerRegisterController {
    
        private static String userNamePattern = "^[A-Za-z0-9]+$";
        private static String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        private static String namePattern = "^[A-Za-z]+$";
        private static CustomerBean CustRegBean = new CustomerBean();
        
        public static void checkUsername(String userName){
            if(CustomerRegisterDao.autheticateUserDetails(userName)){//this needs to call the DAO and return true so we know that username isnt taken
                
                checkUsername(JOptionPane.showInputDialog(null,"The username: " + userName + " is taken please enter a new user name", JOptionPane.ERROR_MESSAGE));
            }
            else{
                CustRegBean.setUserName(userName);
            }
        }
        public static void checkEmailAddress(String emailAddress){
            
            if(emailAddress.matches(emailPattern)){
                CustRegBean.setEmailAddress(emailAddress);
            }
            else{
                checkEmailAddress(JOptionPane.showInputDialog(null,"The Email Address: " + emailAddress + " is taken please enter a new user name", JOptionPane.ERROR_MESSAGE));
            }
        }
        public static void checkFirstName(String FName){
            
            if(FName.matches(namePattern)){
                CustRegBean.setFirstName(FName);
            }
            else{
                checkFirstName(JOptionPane.showInputDialog(null,"Names cannot be Null and should not include numbers!", JOptionPane.ERROR_MESSAGE));
            }
        }
        public static void checkSurName(String SName){
            
            if(SName.matches(namePattern)){
                CustRegBean.setSurName(SName);
            }
            else{
                checkSurName(JOptionPane.showInputDialog(null,"Names cannot be Null and should not include numbers!", JOptionPane.ERROR_MESSAGE));
            }
        }
        public static void checkPW(String password){
            
            if(password.matches(userNamePattern)){
                 CustRegBean.setPassword(password);
            }
            else{
                checkPW(JOptionPane.showInputDialog(null,"The password must contain at least one upper and one lower /n case letter along with at least one number", JOptionPane.ERROR_MESSAGE));
            }  
        }
        public static void checkPhoneNumber(String phoneNum){
            
            if(phoneNum.matches("^[0-9]+$") && phoneNum.length() <=12 && phoneNum.length() >= 9){
                CustRegBean.setPhoneNum(phoneNum);   
            }
            else{
                checkPhoneNumber(JOptionPane.showInputDialog(null,"A phone number should be numbers 0-9 and <=12 >=9", JOptionPane.ERROR_MESSAGE));
            }
        }
        public static void checkDOB(String DOB){
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    format.parse(DOB);
                    CustRegBean.setDOB(DOB);
                    }
                catch(ParseException e){
                    checkDOB(JOptionPane.showInputDialog(null,"Date of birth should be yyyy-MM-dd", JOptionPane.ERROR_MESSAGE));
                    }
        }
            
}
        