package controller;

import DAO.FeedbackDAO;
import bean.FeedbackBean;
import bean.StaffBean;
import view.FeedBackView1;


/**
 *
 * @author mjs-laptop
 */
public class feedbackController {
    
    FeedBackView1 feedback;
    private final FeedbackBean feedbackBean = new FeedbackBean();
    StaffBean staff;
    
    public feedbackController(StaffBean aStaff) {
        
        staff = aStaff;
        feedback = new FeedBackView1();
       feedback.setVisible(true);
       
    }
    
        public void submitFeedback(int waiterScoreLabel, int reservationID){
        
         feedbackBean.setFeedbackMark(waiterScoreLabel);
         feedbackBean.setReservationID(reservationID);
         feedbackBean.setStaffID(staff.getUserID());
         
         FeedbackDAO feedbackDao = new FeedbackDAO();
         feedbackDao.setFeedback(feedbackBean);
         
    }
    
}
