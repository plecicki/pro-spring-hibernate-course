package com.kodilla.jms.receiver;

import com.kodilla.jms.domain.OrderDto;
import com.kodilla.jms.domain.Products;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @JmsListener(containerFactory = "jmsFactory", destination = "queue-test")
    public void receive(String message) {
        System.out.println("Received the message: " + message);
    }

    @JmsListener(containerFactory = "jmsFactory", destination = "queue-orders")
    public void receive(OrderDto orderDto) {
        System.out.println("Receiver: " + orderDto.getReceiver());
        System.out.println("Sender: " + orderDto.getSender());
        int i = 1;
        for (Products product : orderDto.getProductsList()) {
            System.out.println("Product " + i++ + " = " + product.toString());
        }
    }
}
