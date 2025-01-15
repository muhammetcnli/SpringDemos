package com.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "Hello world"

    @GetMapping("/")
    public String sayHello(){
        return "Hello, World!";
    }

    // expose new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "This is daily workout!";
    }
}
