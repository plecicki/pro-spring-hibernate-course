package com.kodilla.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class KodillaJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaJmsApplication.class, args);
    }

}
