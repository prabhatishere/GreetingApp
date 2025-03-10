package com.example.GreetingAPP.dto;
public class PasswordDTO {

    String password;

    PasswordDTO(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}