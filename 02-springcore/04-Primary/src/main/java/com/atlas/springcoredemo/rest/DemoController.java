package com.atlas.springcoredemo.rest;

import com.atlas.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final Coach myCoach;

    @Autowired
    public DemoController(Coach givenCoach){
        myCoach = givenCoach;
    }

    @GetMapping("/dailyworkout")
    public String giveDailyWorkout(){
        return  myCoach.getDailyWorkout();
    }
}
