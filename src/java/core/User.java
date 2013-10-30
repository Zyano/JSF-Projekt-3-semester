package core;

public class User {
    private String userName;
    private String password;
    private int id;
    private boolean admin;
    
    public User() {
    }
    
    public User(String name, String password, boolean admin) {
        userName = name;
        this.password = password;
        this.admin = admin;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    
    public int getId() {
        return id;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public boolean isAdmin() {
        return admin;
    }
    
    public void changeAdminFlag() {
        admin = !admin;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
}