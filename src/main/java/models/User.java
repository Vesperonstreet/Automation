package models;

public class User {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
