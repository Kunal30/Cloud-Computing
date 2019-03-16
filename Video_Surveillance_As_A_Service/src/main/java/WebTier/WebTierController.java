package WebTier;

import org.springframework.web.bind.annotation.RestController;

import EC2.EC2;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class WebTierController {

	@RequestMapping("/reqobj")
    public String request_object_detection() {
       // creating an ec2 instance to handle the customer request
		EC2 ec2=new EC2();
		ec2.createinstance();		
       return "Request for object detection sent and EC2 Instance has been created!!!";
    }
	
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
    
    
	
}
