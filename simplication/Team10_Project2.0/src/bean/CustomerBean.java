package bean;

/**
 *
 * @author Sean
 */
public class CustomerBean extends UserBean{
    
    
    private String DOB;
    private String CC;
    private int loyaltyPoints = 0;

    
    public CustomerBean() {
        super();
        this.CC = null;
        this.DOB = null;
        this.loyaltyPoints = 0;
    }

    public String getDOB() {
        return DOB;
    }

    public String getCC() {
        return CC;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
    
}
