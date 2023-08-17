package com.kodilla.kodillauser;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class JavaAgentController {

    @GetMapping
    ResponseEntity<Boolean> isUserDoingSomething() {
        User user = new User();
        user.doSomething();
        return ResponseEntity.ok(true);
    }
}
