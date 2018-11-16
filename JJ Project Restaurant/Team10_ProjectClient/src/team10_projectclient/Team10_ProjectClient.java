/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team10_projectclient;

import team10_projectclient.view.createreservation.mainmenu;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
/**
 *
 * @author 
 */
public class Team10_ProjectClient extends JFrame{
    private static int userId = 0;
    private static String userName = "";
    private static int userType = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       String username = "TextCustomer";
       int userid = 1;
       int usertype = 1;
       /*
        username = getLoginStates();
        //here I need model return me a string username (if the user has login)
       */
       try{
            if(username != ""){
                /*
                    userType = getUserType();
                 //here I need model return me a usertype (if the user has login)
                */
                if(usertype == 1){//customer
                    userId = userid;
                    userName = username;
                    mainmenu m = new mainmenu();
                    m.setVisible(true);
                    //this is main menu.
                    /*
                    username = login.fetchUsername();// this should be passed in login class!
                    userid = login.fetchUserid();// this should be passed in login class!
                    */
                   // JOptionPane.showMessageDialog(null,userId+userName +"\n"+ fetchUsername() + fetchUserid());
                    
                }
                else if(usertype == 2){
                    /*
                    waiterprofile waiter = new waiterprofile();
                    waiter.setVisible(true);
                    //here need a view of waiter profile
                    */
                }else if(usertype == 3){
                    /*
                    fronthouseprofile waiter = new fronthouseprofile();
                    fronthouseprofile.setVisible(true);
                    //here need a view of fronthouse profile
                    */
                }else if(usertype == 4){
                    /*
                    adminprofile waiter = new adminprofile();
                    adminprofile.setVisible(true);
                    //here need a view of admin profile
                    */
                }
                 
            }
       }catch(Exception e){
           System.out.println("Initialise fail.");
       }
    }

    public static int fetchUserid() {
        return userId;
    }

    public static String fetchUsername() {
        return userName;
    }
    public static int fetchUsertype() {
        return userType;
    }
}
