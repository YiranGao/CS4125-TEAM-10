package view;

/**
 *
 * @author mjs-laptop
 */
import bean.StaffBean;
import controller.staffProfileController;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class StaffProfileView extends JFrame{

	private JPanel contentPane;

        private staffProfileController staffProfile;  

        
	public StaffProfileView(StaffBean staff) {
            
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaffProfile = new JLabel("Staff Profile");
		lblStaffProfile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStaffProfile.setBounds(240, 13, 117, 31);
		contentPane.add(lblStaffProfile);
		
		JLabel lbluserTypeLabel = new JLabel("User Type:");
		lbluserTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbluserTypeLabel.setBounds(12, 59, 117, 31);
		contentPane.add(lbluserTypeLabel);
		
		JLabel lblStaffFeedbackMark = new JLabel("Staff Feedback Mark:");
		lblStaffFeedbackMark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStaffFeedbackMark.setBounds(12, 103, 176, 31);
		contentPane.add(lblStaffFeedbackMark);
		
		JLabel lblRestaurantId = new JLabel("Restaurant ID:");
		lblRestaurantId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRestaurantId.setBounds(12, 147, 117, 31);
		contentPane.add(lblRestaurantId);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(304, 57, 117, 31);
		contentPane.add(lblUserId);
		
		JLabel lblUserName = new JLabel("User name: ");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(304, 103, 117, 31);
		contentPane.add(lblUserName);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(12, 226, 117, 31);
		contentPane.add(lblFirstName);
		
		JLabel lblPhoneNum = new JLabel("Phone Num:");
		lblPhoneNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNum.setBounds(12, 277, 117, 31);
		contentPane.add(lblPhoneNum);
		
		JLabel lblSurname_2 = new JLabel("Surname: ");
		lblSurname_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSurname_2.setBounds(304, 226, 117, 31);
		contentPane.add(lblSurname_2);
		
		JLabel lblEmail_2 = new JLabel("Email: ");
		lblEmail_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail_2.setBounds(304, 287, 117, 31);
		contentPane.add(lblEmail_2);
		
		JLabel lblUsertype = new JLabel("usertype");
                lblUsertype.setText("hello");
		lblUsertype.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsertype.setBounds(132, 57, 117, 31);
		contentPane.add(lblUsertype);
		
		JLabel lblStafffeedbackmark = new JLabel("staffFeedbackMark");
		lblStafffeedbackmark.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStafffeedbackmark.setBounds(153, 104, 91, 31);
		contentPane.add(lblStafffeedbackmark);
		
		JLabel lblRestaurantid = new JLabel("RestaurantID");
		lblRestaurantid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRestaurantid.setBounds(132, 147, 117, 31);
		contentPane.add(lblRestaurantid);
		
		JLabel lblFirstname = new JLabel("FirstName");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFirstname.setBounds(132, 226, 117, 31);
		contentPane.add(lblFirstname);
		
		JLabel lblPhonenum = new JLabel("phoneNum");
		lblPhonenum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhonenum.setBounds(132, 270, 117, 31);
		contentPane.add(lblPhonenum);
		
		JLabel lblSurname = new JLabel("surName");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSurname.setBounds(422, 226, 117, 31);
		contentPane.add(lblSurname);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(422, 287, 117, 31);
		contentPane.add(lblEmail);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(422, 103, 117, 31);
		contentPane.add(lblUsername);
		
		JLabel lblUserid = new JLabel("userID");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUserid.setBounds(422, 59, 117, 31);
		contentPane.add(lblUserid);
	}

}

