package com.amazonaws.samples;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hello Kaise Ho???? Khaana Kha Ke Jaaana Ming Zhao!!!";
    }

}
