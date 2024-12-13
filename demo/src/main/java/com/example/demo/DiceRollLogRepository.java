package com.example.demo;

import com.example.demo.DiceRollLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiceRollLogRepository extends JpaRepository<DiceRollLog, Long> {
}
