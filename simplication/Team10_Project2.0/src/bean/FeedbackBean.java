/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author gtara
 */
public class FeedbackBean {
    private int feedbackID;
    private int staffID;
    private int feedbackMark;
    private int reservationID;
    
    public FeedbackBean() {
        feedbackID = 0;
        staffID = 0;
        feedbackMark = 0;
        reservationID = 0;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public void setFeedbackMark(int feedbackMark) {
        this.feedbackMark = feedbackMark;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public int getStaffID() {
        return staffID;
    }

    public int getFeedbackMark() {
        return feedbackMark;
    }

    public int getReservationID() {
        return reservationID;
    }
    
    
}
