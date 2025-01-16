package com.atlas.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TenisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Tenis training 40 mins!";
    }
}
