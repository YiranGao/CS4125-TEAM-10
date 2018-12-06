package controller;

import org.jcp.xml.dsig.internal.dom.Utils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yiran Gao 17083214
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("* LoginControllerTest: @BeforeClass method");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("* LoginControllerTest: @AfterClass method");
    }
    
    @Before
    public void setUp() {
        System.out.println("* LoginControllerTest: @Before method");
    }
    
    @After
    public void tearDown() {
        System.out.println("* LoginControllerTest: @After method");
    }

    /**
     * Test of submitLogin method, of class LoginController.
     */
    @Test
    public void testSubmitLogin() {
        System.out.println("submitLogin");
        String username = "grandles";
        String password = "gav123";
        LoginController instance = new LoginController();
        try{
            instance.submitLogin(username, password);
        }catch(Exception e){
            fail("The test case failed on login.");
        }
    }
    
    @Test(timeout=1000)
    public void testWithTimeout() {
        String username = "grandles";
        String password = "gav123";
        LoginController instance = new LoginController();
        System.out.println("* UtilsJUnit4Test: test method 2 - testWithTimeout()");
        System.out.println("computing running time !");
    }
    
}
