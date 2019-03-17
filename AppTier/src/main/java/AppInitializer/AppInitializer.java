package AppInitializer;
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

import AppInitializer.AppInitializer;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class AppInitializer {

	public static void main(String args[])throws IOException
{
	SpringApplication.run(AppInitializer.class, args);
	System.out.println("App Tier running!!!");
	
	Listener lis_obj=new Listener();
	
	lis_obj.listen_and_giveOutput();
	
}
}
