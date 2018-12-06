package bean;

/**
 *
 * @author Sean
 */
public class CustomerBean extends UserBean{
    
    
    private String DOB;
    private int CC;
    private int loyaltyPoints = 0;

    
    public CustomerBean() {
        super();
        this.CC = 0;
        this.DOB = null;
        this.loyaltyPoints = 0;
    }

    public String getDOB() {
        return DOB;
    }

    public int getCC() {
        return CC;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setCC(int CC) {
        this.CC = CC;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
    
}
