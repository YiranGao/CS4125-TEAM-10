package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class FeedbackControllerTest {
    
    public FeedbackControllerTest() {
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
     * Test of submitFeedback method, of class FeedbackController.
     */
    @Test
    public void testSubmitFeedback() {
        System.out.println("submitFeedback");
        String waiterScoreLabel = "";
        String reservationID = "";
        FeedbackController instance = null;
        instance.submitFeedback(waiterScoreLabel, reservationID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
