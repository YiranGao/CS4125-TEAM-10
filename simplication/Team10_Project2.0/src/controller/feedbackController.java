package controller;

import DAO.FeedbackDAO;
import bean.FeedbackBean;
import bean.StaffBean;
import view.FeedBackView;


/**
 *
 * @author mjs-laptop
 */
public class feedbackController {
    
    FeedBackView feedback;
    private final FeedbackBean feedbackBean = new FeedbackBean();
    StaffBean staff;
    
    public feedbackController(StaffBean aStaff) {
        
        staff = aStaff;
        feedback = new FeedBackView();
       feedback.setVisible(true);
       
    }
    
        public void submitFeedback(String waiterScoreLabel, String reservationID){
        
         
         feedbackBean.setFeedbackMark(Integer.parseInt(waiterScoreLabel));
         feedbackBean.setReservationID(Integer.parseInt(reservationID));
         feedbackBean.setStaffID(staff.getUserID());
         
         FeedbackDAO feedbackDao = new FeedbackDAO();
         feedbackDao.setFeedback(feedbackBean);
         
    }
    
}
