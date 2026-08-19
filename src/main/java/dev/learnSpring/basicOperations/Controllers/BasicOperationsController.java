package dev.learnSpring.basicOperations.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicOperationsController {

    @GetMapping("/hello")
    String hello(){
        return "Hello World";
    }
}
