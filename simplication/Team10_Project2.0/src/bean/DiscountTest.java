package bean;

import Factory.GetDiscountFactory;

/**
 *
 * @author Patryk
 */
public class DiscountTest {
    
    public static void main(String [] args) {
        GetDiscountFactory discountFactory = new GetDiscountFactory();
        Discount discount = discountFactory.getDiscount(100000);
        discount.getRate();
        int percent = discount.calculateDiscount("");
        System.out.println(percent);
    }
}
