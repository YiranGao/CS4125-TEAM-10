package login.submit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDAOimpl implements userDAO {

    static Connection conn;
    static PreparedStatement ps;
    @Override
    public int insertUser(User c) {
        
        int status=0;
        try{
            conn = myConnectionProvider.getCon();
            ps=conn.prepareStatement("insert into user values(?,?)");
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getName());
            status=ps.executeUpdate();
            conn.close();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public User getUser(String userid, String pass) {
        User c =new User();
        
        
        
        try{
                conn=myConnectionProvider.getCon();
                ps=conn.prepareStatement("select * from user where userid=? and password=?");
                ps.setString(1, userid);
                ps.setString(2, pass);
                
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                c.setUsername(rs.getString(1));
                c.setPassword(rs.getString(2));
                c.setName(rs.getString(3));
                
                }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        return c;
    }
    
}
