package com.example.GreetingAPP.Controller;

import com.example.GreetingAPP.Modal.Greeting;
import com.example.GreetingAPP.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greet")
public class GreetingController {


//=========================UC3========================//
@GetMapping("greets3")
    public String greet(@RequestParam(value = "firstName", required = false) String firstName,
                        @RequestParam(value = "lastName", required = false) String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        }
        if (firstName != null) {
            return "Hello, " + firstName + "!";
        }
        if (lastName != null) {
            return "Hello, " + lastName + "!";
        }
        if (firstName != null && !firstName.trim().isEmpty() && lastName != null && !lastName.trim().isEmpty()) {
            return "Hello, " + firstName + " " + lastName + "!";
        }
        return "Hello, World!";


    }




    //====================UC2===================//
    @Autowired
    private GreetingService greetingService;
    @GetMapping("greet2")
    public String getGreeting2(){
        return greetingService.getGreetingMessage();
    }



    //====================UC1===============================//
    // GET method
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello, World!");
    }

    // POST method
    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Created: " + greeting.getMessage());
    }

    // PUT method
    @PutMapping
    public Greeting updateGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Updated: " + greeting.getMessage());
    }

    // DELETE method
    @DeleteMapping
    public Greeting deleteGreeting(@RequestBody Greeting greeting) {
        return new Greeting("Deleted: " + greeting.getMessage());
    }
}
