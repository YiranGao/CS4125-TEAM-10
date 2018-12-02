package bean;

/**
 *
 * @author Patryk
 */
public class LoyalDiscount extends Discount {

    @Override
    void getRate() {
        rate = 5;
    }
    
}
