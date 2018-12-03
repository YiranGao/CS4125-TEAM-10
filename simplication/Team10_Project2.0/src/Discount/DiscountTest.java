package Discount;

import Discount.Discount;

/**
 *
 * @author Patryk
 */
public class DiscountTest {
    
    
    public static void main(String [] args) {
        SimpleDealsFactory factory = new SimpleDealsFactory();
        Deals deals = factory.createDeals("Milano");
        double percent = deals.applyDiscount("2018-12-06 18:00:00", 1000);
        System.out.println(percent);
    }
}
