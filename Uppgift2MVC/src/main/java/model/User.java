package model;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
     private String userPassword;

    private boolean userOnline;

    public User() {
    }

    public User(String userName, String userPassword, boolean userOnline) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userOnline = userOnline;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }



    public String getUserPassword() {
        return userPassword;
    }

    public boolean isUserOnline() {
        return userOnline;
    }

    public void setUserOnline(boolean userOnline) {
        this.userOnline = userOnline;
    }
}
