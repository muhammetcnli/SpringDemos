package com.atlas.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
// if we use scope prototype, there are 2 different instances, so our check returns false
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{


    public BaseballCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define init method

    @PostConstruct
    public void doStartupThings(){
        System.out.println("In doStartupThings(): " + getClass().getSimpleName());
    }

    // define destroy method

    @PreDestroy
    public void doCleanupStuff(){
        System.out.println("In doCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Hit that ball for 50 mins!";
    }
}
