package Discount;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patryk
 */
public abstract class Discount {
    protected double rate;
    
    abstract void getRate();
    
    public double calculateDiscount() {
        return rate;
    }
}
