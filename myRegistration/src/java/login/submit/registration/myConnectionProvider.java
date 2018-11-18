package login.submit.registration;

import java.sql.Connection;
import java.sql.DriverManager;

public class myConnectionProvider implements myProvider{
    
    static Connection conn=null;
    
    public static Connection getCon(){
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connUrl, username, pwd);
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
       return conn; 
    }
    
}
