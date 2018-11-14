package team10_projectclient;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField phoneNumber;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField emailField;
        private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterPage = new JLabel("Register Page");
		lblRegisterPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblRegisterPage.setBounds(12, 13, 298, 51);
		contentPane.add(lblRegisterPage);
		
		JLabel lblCustName = new JLabel("Customer Name: ");
		lblCustName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCustName.setBounds(12, 77, 143, 26);
		contentPane.add(lblCustName);
		
		JLabel lblPhoneNo = new JLabel("Phone Number: ");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNo.setBounds(12, 158, 143, 26);
		contentPane.add(lblPhoneNo);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = 0;
                                String username = user.getText();
                                String phoneNo = phoneNumber.getText();
                                String password = String.valueOf(passwordField.getPassword());
                                String dateofBirth = textField.getText();
                                String creditCard = textField_2.getText();
                               String gender = textField_1.getText();
                               String email = emailField.getText();
                               
                               
                               
                               Connection conn = null;
                               PreparedStatement pstmt = null;
                               
                               try{
                                   Class.forName("com.mysql.jdbc.Driver");
				   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking_system", "root", "");
                                   pstmt = conn.prepareStatement("insert into customer_table values(?,?,?,?,?,?,?,?)");
                                   pstmt.setInt(1, index);
                                   pstmt.setString(2, username);
                                   pstmt.setString(3, phoneNo);
                                   pstmt.setString(4, password);
                                   pstmt.setString(5, dateofBirth);
                                   pstmt.setString(6, creditCard);
                                   pstmt.setString(7, gender);
                                   pstmt.setString(8, email);
                                   
                                   int i = pstmt.executeUpdate();
                                   if(i>0){
                                       JOptionPane.showMessageDialog(null,"Data is saved sucessfully");
                                   }
                                   else{
                                       JOptionPane.showMessageDialog(null,"data is not saved, sorry");
                                   }
                                   
                               }
                               catch(Exception e){
                                   JOptionPane.showMessageDialog(null,e);
                               }
                                
                                
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setBounds(102, 666, 97, 25);
		contentPane.add(btnRegister);
		
		user = new JTextField();
		user.setBounds(12, 108, 298, 35);
		contentPane.add(user);
		user.setColumns(10);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(12, 186, 298, 35);
		contentPane.add(phoneNumber);
		phoneNumber.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 261, 298, 35);
		contentPane.add(passwordField);
		
		JLabel password = new JLabel("Password: ");
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBounds(12, 234, 143, 26);
		contentPane.add(password);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 348, 298, 35);
		contentPane.add(textField);
		
		JLabel birthNo = new JLabel("Date of Birth: ");
		birthNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		birthNo.setBounds(12, 309, 143, 26);
		contentPane.add(birthNo);
		
		JLabel creditCard = new JLabel("Credit Card Number");
		creditCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		creditCard.setBounds(12, 405, 143, 26);
		contentPane.add(creditCard);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(12, 522, 298, 35);
		contentPane.add(textField_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(12, 492, 143, 26);
		contentPane.add(lblGender);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(12, 606, 298, 35);
		contentPane.add(emailField);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(12, 570, 143, 26);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 444, 298, 35);
		contentPane.add(textField_2);
	}
}
