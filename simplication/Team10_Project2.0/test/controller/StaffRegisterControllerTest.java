package controller;

import bean.StaffBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sean
 */
public class StaffRegisterControllerTest {
    
    public StaffRegisterControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkUsername method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String userName = "";
        StaffRegisterController instance = new StaffRegisterController();
        instance.checkUsername(userName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkEmailAddress method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testCheckEmailAddress() {
        System.out.println("checkEmailAddress");
        String emailAddress = "";
        StaffRegisterController instance = new StaffRegisterController();
        instance.checkEmailAddress(emailAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFirstName method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testCheckFirstName() {
        System.out.println("checkFirstName");
        String FName = "";
        StaffRegisterController instance = new StaffRegisterController();
        instance.checkFirstName(FName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkSurName method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testCheckSurName() {
        System.out.println("checkSurName");
        String SName = "";
        StaffRegisterController instance = new StaffRegisterController();
        instance.checkSurName(SName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPW method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testCheckPW() {
        System.out.println("checkPW");
        String password = "";
        StaffRegisterController instance = new StaffRegisterController();
        instance.checkPW(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPhoneNumber method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testCheckPhoneNumber() {
        System.out.println("checkPhoneNumber");
        String phoneNum = "";
        StaffRegisterController instance = new StaffRegisterController();
        instance.checkPhoneNumber(phoneNum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegisterCustomer method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testRegisterCustomer() {
        System.out.println("RegisterCustomer");
        StaffBean staffRegBean = null;
        StaffRegisterController instance = new StaffRegisterController();
        instance.RegisterCustomer(staffRegBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUserType method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testAddUserType() {
        System.out.println("addUserType");
        int staffUserType = 0;
        StaffRegisterController instance = new StaffRegisterController();
        instance.addUserType(staffUserType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addResturantID method, of class StaffRegisterController.
     */
    @org.junit.Test
    public void testAddResturantID() {
        System.out.println("addResturantID");
        int resturantID = 0;
        StaffRegisterController instance = new StaffRegisterController();
        instance.addResturantID(resturantID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
