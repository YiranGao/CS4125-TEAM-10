package view;

import bean.BookingBean;
import controller.StaffBookingController;

/**
 *
 * @author Patryk
 */
public class ReservationTest {
    public static void main(String [] args) {
        BookingBean model = new BookingBean();
        ReservationBookingView view = new ReservationBookingView();
        StaffBookingController controller = new StaffBookingController(model, view);
        controller.initController();
        
    }
}
