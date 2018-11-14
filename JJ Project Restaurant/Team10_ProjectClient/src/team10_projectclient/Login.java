/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import team10_projectclient.createreservation.mainmenu;

//import myWS.Booking_Service;
//import myWS.Booking_Service_Service;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	private JTextField user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblLoginPage.setBounds(12, 13, 298, 51);
		contentPane.add(lblLoginPage);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(12, 99, 94, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(12, 197, 94, 26);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking_system", "root", "");
					Statement stmt=con.createStatement();
					String sql = "Select * FROM customer_table WHERE customer_name ='"+ user.getText()+"'and customer_password= '"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()){
                                                mainmenu c = new mainmenu();
                                                c.main();
                                        }
                                                
					else JOptionPane.showMessageDialog(null,"Incorrect Login details");
					con.close();
					
					
				}catch(Exception e){
					System.out.println(e);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(108, 281, 97, 25);
		contentPane.add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setBounds(12, 222, 298, 35);
		contentPane.add(pass);
		
		user = new JTextField();
		user.setBounds(12, 128, 298, 35);
		contentPane.add(user);
		user.setColumns(10);
	}

}
