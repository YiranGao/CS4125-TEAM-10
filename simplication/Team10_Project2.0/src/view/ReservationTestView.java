package view;

import bean.BookingBean;
import controller.StaffBookingController;

/**
 *
 * @author Patryk
 */
public class ReservationTestView {
    
    public static void main(String [] args) {
        BookingBean bookingBean = new BookingBean();
        ReservationBookingView reservationBooking = new ReservationBookingView();
        StaffBookingController controller = new StaffBookingController(bookingBean, reservationBooking);
        controller.initController();
    }
    
}
