/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team10_projectclient;

import team10_projectclient.createreservation.mainmenu;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
 
/**
 *
 * @author 
 */
public class Team10_ProjectClient extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       String username = "";
       int usertype = 100;
       /*
        username = getLoginStates();
        //here I need model return me a string username (if the user has login)
       */
       try{
            if(username != ""){
                /*
                    usertype = getUserType();
                 //here I need model return me a usertype (if the user has login)
                */
                if(usertype == 1){
                    mainmenu m = new mainmenu();
                    m.setVisible(true);
                    //this is main menu.
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
    
}
