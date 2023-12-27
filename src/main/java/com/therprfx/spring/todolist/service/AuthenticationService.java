package com.therprfx.spring.todolist.service;

public class AuthenticationService {

    public boolean authenticate(String username, String password){
        boolean validUserName = username.equalsIgnoreCase("rprfelix@gmail.com");
        boolean validPassword = password.equals("Password1");

        return validUserName && validPassword;
    }


}
