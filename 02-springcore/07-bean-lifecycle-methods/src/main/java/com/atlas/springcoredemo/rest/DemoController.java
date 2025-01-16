package com.atlas.springcoredemo.rest;

import com.atlas.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach givenCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = givenCoach;
    }

   // @GetMapping("/check")
    //public String checkSingleton(){

        // because of the singleton annotation(initial), the 2 instances are the same
        // return "Checking beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    // }

    @GetMapping("/dailyworkout")
    public String giveDailyWorkout(){
        return  myCoach.getDailyWorkout();
    }
}
