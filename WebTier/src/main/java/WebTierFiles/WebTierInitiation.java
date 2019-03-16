package WebTierFiles;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import com.vdeosurveillance.vdeo.VdeoApplication;

public class WebTierInitiation {
	public static void main(String args[])throws IOException
	{
		SpringApplication.run(WebTierInitiation.class, args);
		System.out.println("Heeeyyyyaaaa!!!");
//		scaleOut();
		
	}
}
