package login.submit.registration;

public class User {
    
    private String username;
    private String name;
    private String password;
    
    User()
    {
        this.username = "hello";
        this.name = "hello";
        this.password = "hello";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    
}
