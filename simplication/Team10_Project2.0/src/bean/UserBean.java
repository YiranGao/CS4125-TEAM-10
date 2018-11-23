package bean;

/**
 *
 * @author Sean
 */
public class UserBean {
    
    private int userID;
    private String userName;
    private String password;
    private String firstName;
    private String surName;
    private String phoneNum;
    private String emailAddress;
    
    public UserBean(){
        
        this.userID = 0;
        this.userName = null;
        this.emailAddress = null;
        this.firstName = null;
        this.password = null;
        this.surName = null;
        this.phoneNum = null;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }   

}
