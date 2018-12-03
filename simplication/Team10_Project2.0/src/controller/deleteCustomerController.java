package controller;

import DAO.CustomerDAO;

/**
 *
 * @author Sean
 */
public class deleteCustomerController {
    
    public void deleteCustomer(String userName){
        
        CustomerDAO deleteCust = new CustomerDAO();
        deleteCust.deleteCustomer(userName);
        
    }
    
}
