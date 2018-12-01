package controller;

import DAO.CreditcardDAO;
import bean.CreditcardBean;
import view.creditcardView;

/**
 *
 * @author Sean
 */
public class CreditCardController {
    
        creditcardView aCard;
    
    public CreditCardController() {
        
        aCard = new creditcardView(this);
        aCard.setVisible(true);
    }

    public int createCreditCard(String cardHolderName, String expiryMonth, String expiryYear, String cardNumber){
       
        int month = 0, year = 0, cardNum = 0, cardID;
        try{
            cardNum = Integer.parseInt(cardNumber);
        }catch(Exception e){
            
        }
        try{
            month = Integer.parseInt(expiryMonth);
        }catch(Exception e){
        }
        try{
           year = Integer.parseInt(expiryYear) ;
        }catch(Exception e){
        }
        CreditcardDAO createCard = new CreditcardDAO();
        CreditcardBean newCard = new CreditcardBean();
        
        newCard.setHolderName(cardHolderName);
        newCard.setMonth(month);
        newCard.setYear(year);
        newCard.setNumber(cardNumber);
        createCard.addCreditcard(newCard);
        cardID = createCard.getCardID(cardNum);
        
        return cardID;
    }

 
}
