package bean;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patryk
 */
public abstract class Discount {
    protected int rate;
    
    abstract void getRate();
    
    public int calculateDiscount(String date) {
        Calendar c = getDayOfWeek();
        checkDayDiscount(c);
        return rate;
    }
    
    private Calendar getDayOfWeek() {
        String input_date="2018-12-06";
        SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        Date dt1;
        try {
            dt1 = format1.parse(input_date);
            Calendar c = Calendar.getInstance();
            c.setTime(dt1);
            return c;
        } catch (ParseException ex) {
            Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void checkDayDiscount(Calendar c) {
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if(weekday == 5) {
            rate += 5;
        }
        DateFormatSymbols dfs = new DateFormatSymbols();
        System.out.println("Weekday: " + dfs.getWeekdays()[weekday]);
    }
    
}
