package bean;

/**
 *
 * @author Sean
 */
public class StaffBean {
    
        
    private int userType;
    private int staffFeedBackMark;
    private int restaurantID;
    private int userID;
    private String userName;
    private String password;
    private String firstName;
    private String surName;
    private String phoneNum;
    private String emailAddress;
    
    public StaffBean(){
        super();
        this.userType = 0;
        this.staffFeedBackMark = 0;
        this.restaurantID = 0;
        
    }

    public int getUserType() {
        return userType;
    }

    public int getStaffFeedBackMark() {
        return staffFeedBackMark;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setStaffFeedBackMark(int staffFeedBackMark) {
        this.staffFeedBackMark = staffFeedBackMark;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
    
}