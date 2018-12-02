
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.StaffRegisterController;
import java.awt.EventQueue;

import javax.swing.JRadioButton;

public class createRegisterStaffView extends JFrame {
    
    	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
        
        	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createRegisterStaffView frame = new createRegisterStaffView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    

    public createRegisterStaffView() {
        
                
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(36, 46, 77, 25);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(36, 97, 77, 25);
		contentPane.add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(36, 144, 77, 25);
		contentPane.add(lblFirstName);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSurname.setBounds(36, 197, 77, 25);
		contentPane.add(lblSurname);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(288, 46, 102, 25);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(288, 97, 77, 25);
		contentPane.add(lblEmail);
		
		JLabel lblFeedbackMark = new JLabel("Feedback Mark:");
		lblFeedbackMark.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeedbackMark.setBounds(288, 144, 112, 25);
		contentPane.add(lblFeedbackMark);
		
		JLabel lblRestaurantId = new JLabel("Restaurant ID:");
		lblRestaurantId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRestaurantId.setBounds(288, 197, 102, 25);
		contentPane.add(lblRestaurantId);
		
		Username = new JTextField();
		Username.setBounds(117, 38, 136, 32);
		contentPane.add(Username);
		Username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 89, 128, 32);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(125, 137, 136, 32);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 190, 136, 32);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(399, 38, 136, 32);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(399, 83, 136, 32);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(399, 137, 136, 32);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(402, 190, 136, 32);
		contentPane.add(textField_5);
		
		JLabel lblUsertype = new JLabel("UserType:");
		lblUsertype.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsertype.setBounds(59, 252, 77, 25);
		contentPane.add(lblUsertype);
		
		JRadioButton rdbtnWaiter = new JRadioButton("Waiter");
		rdbtnWaiter.setBounds(144, 253, 127, 25);
		contentPane.add(rdbtnWaiter);
		
		JRadioButton rdbtnFrontofHouse = new JRadioButton("Front of House");
		rdbtnFrontofHouse.setBounds(142, 283, 165, 38);
		contentPane.add(rdbtnFrontofHouse);
		
		JRadioButton rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setBounds(142, 326, 165, 38);
		contentPane.add(rdbtnManager);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(353, 264, 97, 25);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(353, 319, 97, 25);
		contentPane.add(btnCancel);
    }
    
    public void closeLogin() {
        this.dispose();
    }
}