package com.example.demo;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Dice {
    private final Random random = new Random();

    public int roll() {
        return random.nextInt(6) + 1; // Lancer un dé entre 1 et 6
    }
}
