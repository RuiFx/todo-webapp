package com.therprfx.spring.todolist.controllers;

import com.therprfx.spring.todolist.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {

    private AuthenticationService authenticationService = new AuthenticationService();

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String goToLoginPage(){
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String username, String password, ModelMap modelMap){
        if(username.isEmpty() || password.isEmpty()){
            String errorMessage="Fields can't be empty!";
            modelMap.put("errorMessage", errorMessage);
            return "login";
        } else if(authenticationService.authenticate(username, password)){
            String welcomeUsername = "Félix";
            modelMap.put("username", welcomeUsername);
            return "welcome";
        } else {
            String errorMessage="Something went wrong, try again!";
            modelMap.put("errorMessage", errorMessage);
            return "login";

        }
    }
}
