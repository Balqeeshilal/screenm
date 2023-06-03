package com.example.screenm;

public class Model_login {
    private String username,email,password,rpassword,phone_number,isactive;

    public Model_login() {

    }
    public Model_login(String username, String email,String rpassword, String phone_number, String password, String isactive) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rpassword = rpassword;
        this.phone_number = phone_number;
        this.isactive = isactive;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String password) {
        this.rpassword = rpassword;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String password) {
        this.phone_number = phone_number;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }
}
