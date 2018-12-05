package Discount;

/**
 *
 * @author Patryk
 */
public class SimpleDealsFactory {
    public Deals createDeals(String chain) {
        if(chain.equals("Milano")) {
            return new MilanoDeals();
        }
        else if(chain.equals("La Cucina")) {
            return new LaCucinaDeals();
        }
        return null;
    }
}
