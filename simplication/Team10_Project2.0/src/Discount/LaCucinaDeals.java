package Discount;

/**
 *
 * @author Patryk
 */
public class LaCucinaDeals extends Deals {
    
    public LaCucinaDeals() {
        super();
        dealDay = "Tuesday";
        dayRate = 8;
    }
    
    public Discount getDiscount(int points) {
        if(points == 0) {
            return null;
        }
        else if(points >= 500 && points < 10000) {
            return new LaCucinaLoyalDiscount();
        }
        else if(points >= 10000) { // is "else if" instead of "if" incase points was a negative integer
            return new LaCucinaPremiumDiscount();
        }
        return null;
    }
                  
}
