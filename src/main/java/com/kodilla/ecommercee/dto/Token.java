package com.kodilla.ecommercee.dto;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class Token {

    public String generateToken(){
        disActiveToken();
        return null;
    }

    @Scheduled(fixedDelay = 60 * 60 * 1000)
    private void disActiveToken(){

    }
}
