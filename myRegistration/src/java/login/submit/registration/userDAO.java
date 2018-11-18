package login.submit.registration;

public interface userDAO {
    
    public int insertUser(User c);
    public User getUser(String username, String pass);
    
}
