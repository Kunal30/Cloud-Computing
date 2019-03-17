package WebTier;
import java.io.*;
import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
//import com.vdeosurveillance.vdeo.VdeoApplication;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebTierInitializer {

public static void main(String args[])throws IOException
{
	SpringApplication.run(WebTierInitializer.class, args);
	System.out.println("DONEZO!!!");
//	scaleOut();
}
public static void scaleOut()
{
	
}
}
