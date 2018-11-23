package view;

import controller.CustomerRegisterController;
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

public class CustomerRegister extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField phoneNumber;
	private JPasswordField passwordField;
	private JTextField firstName;
	private JTextField SurName;
	private JTextField DateOfBirth;
        private JTextField CreditCard;
        private JTextField emailAddress;
        private CustomerRegister register;

	public CustomerRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterPage = new JLabel("Register Page");
		lblRegisterPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblRegisterPage.setBounds(12, 8, 298, 51);
		contentPane.add(lblRegisterPage);

		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = 0;
                                CustomerRegisterController createCust = new CustomerRegisterController();
                                createCust.checkUsername(userName.getText());
                                createCust.checkEmailAddress( emailAddress.getText());
                                createCust.checkFirstName(firstName.getText());
                                createCust.checkSurName( SurName.getText());
                                createCust.checkPW(String.valueOf(passwordField.getPassword()));
                                createCust.checkPhoneNumber(phoneNumber.getText());
                                createCust.checkDOB(DateOfBirth.getText());
                                register.closeRegister();                    
                        }                
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegister.setBounds(102, 666, 97, 25);
		contentPane.add(btnRegister);
		        
                JLabel userNameLable = new JLabel("Username: ");
		userNameLable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userNameLable.setBounds(12, 30, 143, 26);
		contentPane.add(userNameLable);
               
		userName = new JTextField();
		userName.setBounds(12, 60, 298, 35);
		contentPane.add(userName);
		userName.setColumns(10);
		
                JLabel phoneNumeberLable = new JLabel("Phone Number: ");
		phoneNumeberLable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNumeberLable.setBounds(12, 110, 143, 26);
		contentPane.add(phoneNumeberLable);
		
		phoneNumber = new JTextField();
                phoneNumber.setColumns(10);
		phoneNumber.setBounds(12, 140, 298, 35);
		contentPane.add(phoneNumber);
		
		JLabel passwordLable = new JLabel("Password: ");
		passwordLable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLable.setBounds(12, 190, 143, 26);
		contentPane.add(passwordLable);
		
		passwordField = new JPasswordField();
                passwordField.setColumns(10);
		passwordField.setBounds(12, 220, 298, 35);
		contentPane.add(passwordField);
                
		JLabel firstNameLable = new JLabel("First name: ");
		firstNameLable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		firstNameLable.setBounds(12, 270, 143, 26);
		contentPane.add(firstNameLable);
 		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(12, 300, 298, 35);
		contentPane.add(firstName);
                
                JLabel surNameLable = new JLabel("Surname:");
		surNameLable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		surNameLable.setBounds(12, 350, 143, 26);
		contentPane.add(surNameLable);
                
		SurName = new JTextField();
		SurName.setColumns(10);
		SurName.setBounds(12, 380, 298, 35);
		contentPane.add(SurName);                
		
		JLabel DateOfBirthLable = new JLabel("Date of Birth: ");
		DateOfBirthLable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DateOfBirthLable.setBounds(12, 430, 143, 26);
		contentPane.add(DateOfBirthLable);
                
                DateOfBirth = new JTextField();
		DateOfBirth.setColumns(10);
                DateOfBirth.setBounds(12, 460, 298, 35);
		contentPane.add(DateOfBirth);
		
		JLabel creditCardLable = new JLabel("Credit Card Number:");
		creditCardLable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		creditCardLable.setBounds(12, 510, 143, 26);
		contentPane.add(creditCardLable);

                CreditCard = new JTextField();
		CreditCard.setColumns(10);
                CreditCard.setBounds(12, 540, 298, 35);
		contentPane.add(CreditCard);
		
		JLabel lblEmail = new JLabel("Email Address:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(12, 590, 143, 26);
		contentPane.add(lblEmail);
                
                emailAddress = new JTextField();
		emailAddress.setColumns(10);
		emailAddress.setBounds(12, 620, 298, 35);
		contentPane.add(emailAddress);

	}

    private void closeRegister() {
        this.dispose();
    }
}
