package com.kodilla.events.event;

import org.springframework.context.ApplicationEvent;

public class CalculatorRegisteredEvent extends ApplicationEvent {

    private String operationName;

    public CalculatorRegisteredEvent(Object source, String operationName) {
        super(source);
        this.operationName = operationName;
    }

    public String getOperationName() {
        return operationName;
    }
}
