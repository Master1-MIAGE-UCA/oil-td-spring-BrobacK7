package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diceLogs")
public class DiceLogController {

    @Autowired
    private DiceRollLogRepository diceRollLogRepository;

    @GetMapping
    public List<DiceRollLog> getAllDiceLogs() {
        return diceRollLogRepository.findAll();
    }
}
