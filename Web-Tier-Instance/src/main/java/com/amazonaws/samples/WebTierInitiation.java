package com.amazonaws.samples;
import java.io.*;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.vdeosurveillance.vdeo.VdeoApplication;

@RestController
public class WebTierInitiation {

	public static void main(String args[])throws IOException
	{
		SpringApplication.run(VdeoApplication.class, args);
		System.out.println("Heeeyyyyaaaa!!!");
//		scaleOut();
		
	}
	public static void scaleOut()
	{
		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
        try {
            credentialsProvider.getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/home/kunal/.aws/credentials), and is in valid format.",
                    e);
        }
		
		// creating an SQS object to send input trigger to the queue for video surveillance
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.US_WEST_1)
                .build();
		
		List<String> queueURLs= sqs.listQueues().getQueueUrls();
		String queueURL= queueURLs.get(0);
		System.out.println(queueURL);
		
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueURL);

		while(true)
	    {
//			System.out.println("Helllloo Worlrlrlrlrlrd");
		}        
		

	}
    
//	@RequestMapping("/")
//	public String index() {
//	    	System.out.println("Heyaaaaaa2");
//	       return "Hello Kaise Ho???? Khaana Kha Ke Jaaana Ming Zhao!!!";
//	    }
}
