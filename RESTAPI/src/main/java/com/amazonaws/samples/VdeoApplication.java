package com.amazonaws.samples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VdeoApplication {

	static String USER_AGENT = "Chrome/71";
	public static void main(String[] args) throws IOException {
		SpringApplication.run(VdeoApplication.class, args);
//		URL url= new URL("http://google.com");
//		HttpURLConnection con= (HttpURLConnection)url.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//		System.out.println("Successfully DONE!!!!!!");
//		int status= con.getResponseCode();
//		BufferedReader obj=new BufferedReader(new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuilder content = new StringBuilder();
//		while ((inputLine = obj.readLine()) != null) {
//		    content.append(inputLine);
////		    System.out.println(inputLine);
//		}
//		System.out.println(content.toString());
//		System.out.println(status);
	}

	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }	
}
