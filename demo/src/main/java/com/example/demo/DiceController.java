package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dice")
public class DiceController {

    @Autowired
    private DiceService diceService;

    @GetMapping("/rollDice")
    public List<Integer> rollSingleDice() {
        return diceService.rollDice(1);
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        return diceService.rollDice(count);
    }
}
