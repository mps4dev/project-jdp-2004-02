package com.kodilla.ecommercee.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.nio.charset.Charset;
import java.util.Random;

@Getter
@EnableScheduling
@NoArgsConstructor
public class Token {
    private static String token;
    private static boolean isActive;

    public void generateToken(){
        generateTokenCode();
        disactivate();
    }

    private void generateTokenCode(){
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        String generatedToken = new String(array, Charset.forName("UTF-8"));
        setToken(generatedToken);
    }

    @Scheduled(fixedDelay = 10000)
    private void disactivate(){
        setIsActive(false);
        setToken("");
    }

    private void setToken(String token) {
        this.token = token;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
