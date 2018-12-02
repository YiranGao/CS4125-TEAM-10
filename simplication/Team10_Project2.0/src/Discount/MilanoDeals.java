package Discount;

/**
 *
 * @author Patryk
 */
public class MilanoDeals extends Deals {
    
    public MilanoDeals() {
        super();
        dealDay = "Thursday";
        dayRate = 5;
    }
    
    public Discount getDiscount(int points) {
        if(points == 0) {
            return null;
        }
        else if(points >= 1000 && points < 10000) {
            return new MilanoLoyalDiscount();
        }
        else if(points >= 10000) { // is "else if" instead of "if" incase points was a negative integer
            return new MilanoPremiumDiscount();
        }
        return null;
    }
                  
}
