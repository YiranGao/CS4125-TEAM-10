package DAO;

import bean.feedbackBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBConnection;

/**
 *
 * @author Sean
 */
public class FeedbackDAO {
    
    private feedbackBean feedback;
    
    public void setFeedback(feedbackBean feedback){
        
        Connection con = null;
        Statement statement = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            String sql = "insert into feedback(staff_id, feedback_mark, reservation_id";
            sql += ") values(?,?,?)";
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, feedback.getStaffID());
            ps.setInt(2, feedback.getFeedbackMark());
            ps.setInt(3, feedback.getReservationID());
           
            ps.executeUpdate();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public feedbackBean getFeedback(int feedbackID){
        
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
 
        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select * from feedback");
 
            while(resultSet.next()) {     
 
                if(feedbackID == resultSet.getInt("feedback_id")) {
                    feedback.setFeedbackID(resultSet.getInt("feedback_id"));
                    feedback.setStaffID(resultSet.getInt("staff_id"));
                    feedback.setFeedbackMark(resultSet.getInt("feedback_mark"));
                    feedback.setReservationID(resultSet.getInt("reservation_id"));
                }
                    
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
        
}


