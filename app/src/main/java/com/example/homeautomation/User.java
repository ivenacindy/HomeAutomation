package com.example.homeautomation;

public class User {
    private String userID;
    private String nama;
    private String password;
    private String token;
    private String email;

    public User(String userID, String nama, String password, String token, String email){
        this.userID = userID;
        this.nama = nama;
        this.password = password;
        this.token = token;
        this.email = email;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
