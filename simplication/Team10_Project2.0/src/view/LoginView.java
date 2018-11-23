
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

import controller.LoginController;

public class LoginView extends JFrame {
    
    private JPanel contentPane;
    private JTextField password;
    private JTextField username;
    
    private LoginController login;

    public LoginView(LoginController aLogin) {
        
        login = aLogin;
                
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
        
        username = new JTextField();
        username.setBounds(12, 128, 298, 35);
        contentPane.add(username);
        username.setColumns(10);
	
        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(12, 197, 94, 26);
        contentPane.add(lblPassword);
        
        password = new JPasswordField();
        password.setBounds(12, 222, 298, 35);
        contentPane.add(password);
	
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                login.submitLogin(username.getText(), password.getText());
            }
        });
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loginButton.setBounds(100, 281, 97, 25);
        contentPane.add(loginButton);
    }
    
    public void closeLogin() {
        this.dispose();
    }
}