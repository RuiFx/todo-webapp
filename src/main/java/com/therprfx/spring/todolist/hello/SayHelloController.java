package com.therprfx.spring.todolist.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayHelloController {

    public String message =  "Hello! What you learning today?";

    @RequestMapping("say-hello")
    public String sayHello(){
        return "sayHello";
    }


}
