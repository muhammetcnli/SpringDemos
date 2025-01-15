package com.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

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

    // inject properties

    @GetMapping("/properties")
    public String showProperties(){
        return "Coach name is: " + coachName + ", Team name is: " + teamName ;
    }
}
