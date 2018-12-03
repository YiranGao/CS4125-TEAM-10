package Discount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patryk
 */
public abstract class Deals {
    private double rate;
    protected String dealDay;
    protected double dayRate;
    
    
    protected abstract Discount getDiscount(int points);
            
    public double applyDiscount(String inputDate, int points) {
        Discount discount = getDiscount(points);
        discount.getRate();
        rate = discount.calculateDiscount();
        checkDayDiscount(getDayName(inputDate));
        return rate;
    }  
    
    private String getDayName(String inputDate) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(inputDate);
        } catch (ParseException ex) {
            Logger.getLogger(Discount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
    }
    
    private void checkDayDiscount(String day) {
        if(dealDay.equals(day)) {
            rate += dayRate;
        }
    }
}
