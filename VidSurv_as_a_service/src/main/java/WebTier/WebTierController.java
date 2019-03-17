package WebTier;

import org.springframework.web.bind.annotation.RestController;

import EC2.EC2;
import SQS.SQS;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class WebTierController {

	@RequestMapping("/reqobj")
    public String request_object_detection() {
       
		SQS sqs=new SQS();
		sqs.sendMessage("Sending a request for object detection");						
       return "Request for object detection sent in SQS_IN queue";
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
