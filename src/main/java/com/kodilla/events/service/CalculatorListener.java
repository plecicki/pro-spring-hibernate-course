package com.kodilla.events.service;

import com.kodilla.events.event.CalculatorRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorListener implements ApplicationListener<CalculatorRegisteredEvent> {

    private final Logger logger = LoggerFactory.getLogger(CalculatorListener.class);

    @Override
    public void onApplicationEvent(CalculatorRegisteredEvent event) {
        logger.info("Operation " + event.getOperationName() + " has been executed!");
    }
}
