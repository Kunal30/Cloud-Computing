package com.vdeosurveillance.vdeo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/mingu")
    public String index() {
    	System.out.println("A Hulllooo!!");
       return "Welcome to Dr. Z's Project!!";
    }

    @RequestMapping("/pingu")
    public String index2() {
    	System.out.println("A Hulllooo!!");
       return "Return to castle Wolfenstein!!";
    }

    @RequestMapping("/reqobj")
    public String execute() {
    	System.out.println("Request sent");
       return "Request for object detection sent!!!";
    }
}
