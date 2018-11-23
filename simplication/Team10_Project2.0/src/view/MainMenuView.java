/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Yiran Gao - 17083214
 */
public class MainMenuView extends javax.swing.JFrame {
   /* private static String name = Team10_ProjectClient.fetchUsername(); 
    private static int id = Team10_ProjectClient.fetchUserid();
    private static int type = Team10_ProjectClient.fetchUsertype();*/
    /**
     * Creates new form mainmenu
     */
    public MainMenuView() {
      /*name = Team10_ProjectClient.fetchUsername();
      id = Team10_ProjectClient.fetchUserid();
      type = Team10_ProjectClient.fetchUsertype();*/
      //JOptionPane.showMessageDialog(null,name + id);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        createReservationButton = new javax.swing.JButton();
        cancelReservationButton = new javax.swing.JButton();
        modifyReservationButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        profileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        welcomeLabel.setText("Welcome!");

        createReservationButton.setText("Create Reservation");
        createReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createReservationButtonActionPerformed(evt);
            }
        });

        cancelReservationButton.setText("Cancel Reservation");
        cancelReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReservationButtonActionPerformed(evt);
            }
        });

        modifyReservationButton.setText("Modify Reservation");
        modifyReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyReservationButtonActionPerformed(evt);
            }
        });

        usernameLabel.setText("Username");
        /* SeanHelpMe 
        the username label needs text for username.
        usernameLabel.setText(fetchUsername(String username));
        */

        profileButton.setText("Profile");
        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileButtonMouseClicked(evt);
            }
        });
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelReservationButton)
                    .addComponent(modifyReservationButton)
                    .addComponent(createReservationButton))
                .addContainerGap(256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addGap(273, 273, 273))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileButton)
                            .addComponent(usernameLabel))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profileButton)
                .addGap(40, 40, 40)
                .addComponent(createReservationButton)
                .addGap(18, 18, 18)
                .addComponent(modifyReservationButton)
                .addGap(18, 18, 18)
                .addComponent(cancelReservationButton)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createReservationButtonActionPerformed
        // Once clicks the create reservation button it will handle a booking view:
        /* SeanHelpMe
        
        createReservationView(usernameLabel.getText());
        
        ***** those codes should be put on controller:*****
        createReservationView(String username){
            ReservationBooking booking = new ReservationBooking();
            booking.setResizable(false);
            booking.setVisible(true);
            booking.setLocationRelativeTo(null);
        }
        ***** i did not put package info on it*****
        */
        //booking.setAlwaysOnTop(true);
    }//GEN-LAST:event_createReservationButtonActionPerformed

    private void profileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseClicked
        // TODO add your handling code here:
        UserProfileView profile = new UserProfileView();
        profile.setVisible(true);
    }//GEN-LAST:event_profileButtonMouseClicked

    private void cancelReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReservationButtonActionPerformed
       // Once clicks the create reservation button it will handle a cancel booking view:
       /* SeanHelpMe
        
        cancelReservationView(usernameLabel.getText());
        
        ***** those codes should be put on controller:*****
        cancelReservationView(String username){
            CancelReservation cancel = new CancelReservation();
            cancel.setResizable(false);
            cancel.setVisible(true);
            cancel.setLocationRelativeTo(null);
       }
        ***** i did not put package info on it*****
        */
    }//GEN-LAST:event_cancelReservationButtonActionPerformed

    private void modifyReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyReservationButtonActionPerformed
        // Once clicks the create reservation button it will handle a modify booking view:
        /* SeanHelpMe
        
        modifyReservationView(usernameLabel.getText());
        
        ***** those codes should be put on controller:*****
        modifyReservationView(String username){
            ModifyReservation modify = new ModifyReservation();
            modify.setResizable(false);
            modify.setVisible(true);
            modify.setLocationRelativeTo(null);
        }
        ***** i did not put package info on it*****
        */
    }//GEN-LAST:event_modifyReservationButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        //Once the button clicks, lead user to user profile view:
        /* SeanHelpMe
        
        profileView(usernameLabel.getText());
        
        ***** those codes should be put on controller:*****
        profileView(String username){
            UserProfileView profile = new UserProfileView();
            profile.setResizable(false);
            profile.setVisible(true);
            profile.setLocationRelativeTo(null);
        }
        ***** i did not put package info on it*****
        */
    }//GEN-LAST:event_profileButtonActionPerformed
  /*  public static int fetchUserid() {
         return id;
     }

     public static String fetchUsername() {
         return name;
     }
     public static int fetchUsertype() {
         return type;
     }*/
    /**
     * @author Yiran Gao - 17083214
     * @param args the command line arguments
     */
    public static void main() {
        
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelReservationButton;
    private javax.swing.JButton createReservationButton;
    private javax.swing.JButton modifyReservationButton;
    private javax.swing.JButton profileButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables

    
}
