package bean;

/**
 *
 * @author Sean
 */
public class StaffBean extends userBean {
    
    private int userID;
    private String userName;
    private String password;
    private String firstName;
    private String surName;
    private String phoneNum;
    private String emailAddress;
    private int userType;
    private int staffFeedBackMark;
    private int restaurantID;
    
    public StaffBean(){
        super();
        this.userType = 0;
        this.staffFeedBackMark = 0;
        this.restaurantID = 0; 
    }

    public int getUserType() {
        return userType;
    }

    public int getFeedBackMark() {
        return staffFeedBackMark;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setFeedBackMark(int staffFeedBackMark) {
        this.staffFeedBackMark = staffFeedBackMark;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
    
}
