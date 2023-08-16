package com.kodilla.jms.controller;

import com.kodilla.jms.domain.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void processMessage(@RequestBody OrderDto orderDto) {
        jmsTemplate.convertAndSend("queue-orders", orderDto);
    }
}
