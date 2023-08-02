package com.kodilla.events.controller;

import com.kodilla.events.event.CalculatorRegisteredEvent;
import com.kodilla.events.exceptions.CantDivideByZeroException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @GetMapping(path = "/addition")
    public ResponseEntity<BigDecimal> calculateAdding(@RequestParam BigDecimal firstNumber, @RequestParam BigDecimal secondNumber) {
        publisher.publishEvent(
                new CalculatorRegisteredEvent(this, "addition")
        );
        return ResponseEntity.ok(firstNumber.add(secondNumber));
    }

    @GetMapping(path = "/subtraction")
    public ResponseEntity<BigDecimal> calculateSubtraction(@RequestParam BigDecimal firstNumber, @RequestParam BigDecimal secondNumber) {
        publisher.publishEvent(
                new CalculatorRegisteredEvent(this, "subtraction")
        );
        return ResponseEntity.ok(firstNumber.subtract(secondNumber));
    }

    @GetMapping(path = "/multiplication")
    public ResponseEntity<BigDecimal> calculateMultiplication(@RequestParam BigDecimal firstNumber, @RequestParam BigDecimal secondNumber) {
        publisher.publishEvent(
                new CalculatorRegisteredEvent(this, "multiplication")
        );
        return ResponseEntity.ok(firstNumber.multiply(secondNumber));
    }

    @GetMapping(path = "/division")
    public ResponseEntity<BigDecimal> calculateDivision(
            @RequestParam BigDecimal firstNumber,
            @RequestParam BigDecimal secondNumber)
    throws CantDivideByZeroException {
        publisher.publishEvent(
                new CalculatorRegisteredEvent(this, "division")
        );
        if (secondNumber.equals(BigDecimal.ZERO)) {
            throw new CantDivideByZeroException();
        }
        return ResponseEntity.ok(firstNumber.divide(secondNumber,2, RoundingMode.HALF_UP));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
