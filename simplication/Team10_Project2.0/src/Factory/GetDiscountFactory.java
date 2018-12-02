package Factory;

import bean.Discount;
import bean.LoyalDiscount;
import bean.PremiumDiscount;

/**
 *
 * @author Patryk
 */


public class GetDiscountFactory {
    
    public Discount getDiscount(int points) {
        if(points == 0) {
            return null;
        }
        else if(points >= 1000 && points < 10000) {
            return new LoyalDiscount();
        }
        else if(points >= 10000) { // is "else if" instead of "if" incase points was a negative integer
            return new PremiumDiscount();
        }
        return null;
    }
    
}
