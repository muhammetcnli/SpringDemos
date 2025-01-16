package com.atlas.springcoredemo.common;

import com.atlas.springcoredemo.common.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Todays workout is 5 mile run!";
    }
}
