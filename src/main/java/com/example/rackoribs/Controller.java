package com.example.rackoribs;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final BinaryConverter bc = new BinaryConverter();
    private static final String template = "Hello, %s!";
    private static final String template1 = "Yello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/tobinary")
    public double toBinary(@RequestParam(value = "number") String s){
        return bc.from_number(s);
    }

    @GetMapping("/frombinary")
    public float fromBinary(@RequestParam(value = "binary") String s){
        return bc.from_binary(s);
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting1")
    public Greeting greeting1(@RequestParam(value = "name", defaultValue = "squirrel")String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template1, name));
    }
}