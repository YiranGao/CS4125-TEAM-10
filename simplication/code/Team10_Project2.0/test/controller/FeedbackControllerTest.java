package controller;

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
public class FeedbackControllerTest {
    
    public FeedbackControllerTest() {
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
     * Test of submitFeedback method, of class FeedbackController.
     */
    @Test
    public void testSubmitFeedback() {
        System.out.println("submitFeedback");
        String waiterScoreLabel = "2";
        String reservationID = "2";
        FeedbackController instance = null;
        instance.submitFeedback(waiterScoreLabel, reservationID);
        try{
            instance.submitFeedback(waiterScoreLabel, reservationID);
        }catch(Exception e){
             fail("The test case failed on submit feedback.");
        }
    }
    
    @Test(timeout=1000)
    public void testWithTimeout() {
        System.out.println("submitFeedback");
        String waiterScoreLabel = "2";
        String reservationID = "2";
        FeedbackController instance = null;
        instance.submitFeedback(waiterScoreLabel, reservationID);
        System.out.println("* UtilsJUnit4Test: test method 1 - testWithTimeout()");
        System.out.println("computing running time !");
    }
}
