package com.example.GreetingAPP;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("greet")
public class GreetingController {

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
