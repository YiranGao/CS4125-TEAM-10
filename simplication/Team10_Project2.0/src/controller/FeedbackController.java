package controller;

import DAO.FeedbackDAO;
import bean.FeedbackBean;
import bean.StaffBean;
import view.FeedBackView;


/**
 *
 * @author mjs-laptop
 */
public class FeedbackController {
    
    FeedBackView feedback;
    private final FeedbackBean feedbackBean = new FeedbackBean();
    StaffBean staff;
    
    public FeedbackController(StaffBean aStaff) {
        
        staff = aStaff;
        feedback = new FeedBackView();
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
