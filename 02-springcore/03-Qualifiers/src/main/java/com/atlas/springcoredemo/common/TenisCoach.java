package com.atlas.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Tenis training 40 mins!";
    }
}
