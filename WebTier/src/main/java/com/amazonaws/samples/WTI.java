package com.amazonaws.samples;

import java.io.IOException;

import org.springframework.boot.SpringApplication;

import com.vdeosurveillance.vdeo.VdeoApplication;

import WebTierFiles.WebTierInitiation;

public class WTI {
	public static void main(String args[])throws IOException
	{
		SpringApplication.run(VdeoApplication.class, args);
		System.out.println("Heeeyyyyaaaa!!!");
//		scaleOut();
		
	}
}
