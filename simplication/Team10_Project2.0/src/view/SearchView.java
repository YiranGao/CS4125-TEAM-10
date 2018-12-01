
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
import controller.SearchController;

public class SearchView extends JFrame {
    
    private JPanel contentPane;
    private JTextField searchEntry;
    private SearchController controller;
    private String SearchType, search, buttonText;
    
    private LoginController login;

    public SearchView(String searchType,SearchController aController) {
        SearchType = searchType;
        controller = aController;
        String title = "Search Page";
        String string = "Search ";
                
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 340, 382);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        switch(SearchType) {
            case "update booking"  : string += "booking ID"; buttonText = "Update"; break;
            case "cancel booking"  : string += "booking ID"; buttonText = "Cancel"; break;
            case "update staff"    : string += "staff username"; buttonText = "Update"; break;
            case "delete staff"    : string += "staff username"; buttonText = "Delete"; break;
            case "update customer" : string += "customer username"; buttonText = "Update"; break;
            case "delete customer" : string += "customer username"; buttonText = "Delete"; break;
        }
	
        JLabel lblLoginPage = new JLabel(title);
        lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblLoginPage.setBounds(12, 13, 298, 51);
        contentPane.add(lblLoginPage);
	
        JLabel lblText = new JLabel(string);
        lblText.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblText.setBounds(12, 99, 300, 26);
        contentPane.add(lblText);
        
        searchEntry = new JTextField();
        searchEntry.setBounds(12, 128, 298, 35);
        contentPane.add(searchEntry);
        searchEntry.setColumns(10);
	
        JButton searchButton = new JButton(buttonText);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.search(searchEntry.getText());
            }
        });
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        searchButton.setBounds(50, 281, 97, 25);
        contentPane.add(searchButton);
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        closeButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        closeButton.setBounds(150, 281, 97, 25);
        contentPane.add(closeButton);
    }
    
    public void closeSearch() {
        this.dispose();
    }
}