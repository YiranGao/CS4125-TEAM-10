/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.util.Calendar;
import javax.swing.JTextField;

/**
 *
 * @author Yiran Gao - 17083214
 */
public class UserProfileView extends javax.swing.JFrame {

    /**
     * Creates new form userprofile
     */
    public UserProfileView() {
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

        welcomeTextLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        birthTextLabel = new javax.swing.JLabel();
        birthLabel = new javax.swing.JLabel();
        emailTextLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        cardnumTextLabel = new javax.swing.JLabel();
        cardnumLabel = new javax.swing.JLabel();
        currentDateLabel = new javax.swing.JLabel();
        newcardTextField = new javax.swing.JTextField();
        newcardholderTextField = new javax.swing.JTextField();
        newcardDateTextField = new javax.swing.JTextField();
        changecardButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeTextLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        welcomeTextLabel.setText("WELCOME !");

        usernameLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        usernameLabel.setText("Username");

        birthTextLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        birthTextLabel.setText("Birth:");

        birthLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        birthLabel.setText("jLabel4");

        emailTextLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        emailTextLabel.setText("Email:");

        emailLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        emailLabel.setText("jLabel6");

        cardnumTextLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        cardnumTextLabel.setText("CardNum:");

        cardnumLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        cardnumLabel.setText("jLabel8");

        currentDateLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        currentDateLabel.setText("username");
        Calendar c = Calendar.getInstance();
 
 int year = c.get(Calendar.YEAR);  
 
 int month = c.get(Calendar.MONTH);   
 
 int date = c.get(Calendar.DATE);      
 
 currentDateLabel.setText(year + "/" + (month+1) + "/" + date);

        newcardTextField.setForeground(new java.awt.Color(153, 153, 153));
        newcardTextField.setText("NEW CARD NUMBER");
        newcardTextField.setText("New Card Num");
        newcardTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newcardTextFieldMouseClicked(evt);
            }
        });
        newcardTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newcardTextFieldActionPerformed(evt);
            }
        });

        newcardholderTextField.setForeground(new java.awt.Color(153, 153, 153));
        newcardholderTextField.setText("NEW CARD HOLDER");
        newcardholderTextField.setText("Card Holder");
        newcardholderTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newcardholderTextFieldMouseClicked(evt);
            }
        });
        newcardholderTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newcardholderTextFieldActionPerformed(evt);
            }
        });

        newcardDateTextField.setForeground(new java.awt.Color(153, 153, 153));
        newcardDateTextField.setText("EXPIRE DATE");
        newcardDateTextField.setText("Valid Date (MM/YY)");
        newcardDateTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newcardDateTextFieldMouseClicked(evt);
            }
        });

        changecardButton.setText("ChangeCard");
        changecardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changecardButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcomeTextLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTextLabel)
                                    .addComponent(cardnumTextLabel)
                                    .addComponent(birthTextLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(birthLabel)
                                    .addComponent(cardnumLabel)
                                    .addComponent(emailLabel)))
                            .addComponent(newcardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newcardholderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(newcardDateTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(changecardButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(52, 52, 52)
                                .addComponent(closeButton)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(usernameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                        .addComponent(currentDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomeTextLabel)
                    .addComponent(usernameLabel)
                    .addComponent(currentDateLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthTextLabel)
                            .addComponent(birthLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTextLabel)
                            .addComponent(emailLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cardnumLabel)
                            .addComponent(cardnumTextLabel))
                        .addGap(18, 18, 18)
                        .addComponent(newcardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(newcardholderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newcardDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changecardButton)
                            .addComponent(closeButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void changecardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changecardButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changecardButtonActionPerformed

    private void newcardTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcardTextFieldMouseClicked
        // TODO add your handling code here:
        textField(newcardTextField);
        newcardTextField.setText("");
    }//GEN-LAST:event_newcardTextFieldMouseClicked

    private void newcardholderTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcardholderTextFieldMouseClicked
        // TODO add your handling code here:
        textField(newcardholderTextField);
    }//GEN-LAST:event_newcardholderTextFieldMouseClicked

    private void newcardDateTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newcardDateTextFieldMouseClicked
        // TODO add your handling code here:
        textField(newcardDateTextField);
    }//GEN-LAST:event_newcardDateTextFieldMouseClicked

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void newcardTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newcardTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newcardTextFieldActionPerformed

    private void newcardholderTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newcardholderTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newcardholderTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(UserProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserProfileView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserProfileView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthLabel;
    private javax.swing.JLabel birthTextLabel;
    private javax.swing.JLabel cardnumLabel;
    private javax.swing.JLabel cardnumTextLabel;
    private javax.swing.JButton changecardButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel currentDateLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailTextLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField newcardDateTextField;
    private javax.swing.JTextField newcardTextField;
    private javax.swing.JTextField newcardholderTextField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel welcomeTextLabel;
    // End of variables declaration//GEN-END:variables

    private void textField(JTextField t) {
        t.setForeground(Color.black);
        t.setText("");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
