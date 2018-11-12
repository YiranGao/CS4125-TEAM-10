/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team10_projectclient.createreservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Yiran Gao - 17083214
 */
public class createReservation extends JFrame implements ActionListener {
    createReservation(){
         reservationBooking reservationbooking = new reservationBooking();
         //reservationbooking.initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
