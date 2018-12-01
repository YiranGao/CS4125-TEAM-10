package view;

import controller.CreditCardController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Sean
 */
public class creditcardView extends JFrame {
    
    private JPanel contentPane;
    private JTextField cardHolderName;
    private JTextField validMonth;
    private JTextField validYear;
    private JTextField cardNumber;
    private CreditCardController aCard;

    public creditcardView(CreditCardController creditcard) {
        
        aCard = creditcard;
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 340, 382);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
	
        JLabel lblLoginPage = new JLabel("Register Credit Card");
        lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblLoginPage.setBounds(12, 13, 298, 51);
        contentPane.add(lblLoginPage);
	
        JLabel lblCardHolderName = new JLabel("Card holder: ");
        lblCardHolderName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCardHolderName.setBounds(12, 99, 94, 26);
        contentPane.add(lblCardHolderName);
        
        cardHolderName = new JTextField();
        cardHolderName.setBounds(12, 128, 298, 35);
        contentPane.add(cardHolderName);
        cardHolderName.setColumns(10);
        
        JLabel lblExpiryMonth = new JLabel("Expiry Month: ");
        lblExpiryMonth.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblExpiryMonth.setBounds(12, 99, 94, 26);
        contentPane.add(lblExpiryMonth);
        
        validMonth = new JTextField();
        validMonth.setBounds(12, 128, 298, 35);
        contentPane.add(validMonth);
        validMonth.setColumns(10);
        
        JLabel lblExpiryYear = new JLabel("Expiry Year: ");
        lblExpiryYear.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblExpiryYear.setBounds(12, 99, 94, 26);
        contentPane.add(lblExpiryYear);
        
        validYear = new JTextField();
        validYear.setBounds(12, 128, 298, 35);
        contentPane.add(validYear);
        validYear.setColumns(10);
        
        JLabel lblCardNumber = new JLabel("Card number: ");
        lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCardNumber.setBounds(12, 99, 94, 26);
        contentPane.add(lblCardNumber);
        
        cardNumber = new JTextField();
        cardNumber.setBounds(12, 128, 298, 35);
        contentPane.add(cardNumber);
        cardNumber.setColumns(10);
        
	
        JButton AddCard = new JButton("Add Card");
        AddCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //login.submitLogin(username.getText(), password.getText());
                aCard.createCreditCard(cardHolderName.getText(), validMonth.getText(), validYear.getText(), cardNumber.getText());
            }
        });
        AddCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
        AddCard.setBounds(100, 281, 97, 25);
        contentPane.add(AddCard);
    }
    
    public void closeLogin() {
        this.dispose();
    }


}
    

