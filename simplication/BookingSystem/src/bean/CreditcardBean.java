/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author gtara
 */
public class CreditcardBean {
    
    private int cardID;
    private String holderName;
    private int year;
    private int month;
    private String number;
    
    public CreditcardBean() {
        cardID = 0;
        holderName = "";
        year = 0;
        month = 0;
        number = "";
    }

    public int getCardID() {
        return cardID;
    }

    public String getHolderName() {
        return holderName;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getNumber() {
        return number;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
    
}
