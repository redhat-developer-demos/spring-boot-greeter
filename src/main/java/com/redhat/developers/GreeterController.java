package com.redhat.developers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GreeterController {


    @GetMapping("/greet/{user}")
    public String greet(@Value("${greeter.prefix}") String prefix, @PathVariable("user") String user) {
        log.info("Prefix :{} and User:{}", prefix, user);
        if (prefix == null) {
            prefix = "Hello!";
        }

        return String.format("%s %s! Welcome to Spring Boot on Kubernetes!", prefix, user);
    }
}
