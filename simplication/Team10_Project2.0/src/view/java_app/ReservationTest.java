package view.java_app;

import bean.BookingBean;
import controller.StaffBookingController;

/**
 *
 * @author Patryk
 */
public class ReservationTest {
    
    public static void main(String [] args) {
        BookingBean bookingBean = new BookingBean();
        ReservationBooking reservationBooking = new ReservationBooking();
        StaffBookingController controller = new StaffBookingController(bookingBean, reservationBooking);
        controller.initController();
    }
    
}
