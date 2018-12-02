package bean;

/**
 *
 * @author Patryk
 */
public class PremiumDiscount extends Discount {

    @Override
    void getRate() {
        rate = 10;
    }
    
}
