package AppInitializer;

import SQS.SQS;
import java.io.*;
import java.net.URL;
import java.util.*;

import org.apache.tomcat.util.http.fileupload.FileUtils;
public class Listener {

	public void listen_and_giveOutput() throws IOException
	{
		System.out.println("Listening!!!!!!!");
		SQS sqs=new SQS();
		while(true)
		{
			String msg=sqs.receiveMessages();
			System.out.println(msg+" Hello");
			if(!msg.equals(""))
			{
				dark_classification(msg);
				
//				System.out.println(answer);
			}
			System.out.println("Listening!!!!!!!");
		}
	}
	
	public void dark_classification(String msg)throws IOException
	{
		downloadFile();
		runPythonScripts();
		
	}
	public void runPythonScripts()throws IOException
	{
		
		Process p = Runtime.getRuntime().exec("python /home/kunal/Desktop/HW.py");
		
		BufferedReader stdInput = new BufferedReader(new 
                InputStreamReader(p.getInputStream()));

           BufferedReader stdError = new BufferedReader(new 
                InputStreamReader(p.getErrorStream()));
           
           String s;
           // read the output from the command
           System.out.println("Here is the standard output of the command:\n");
           while ((s = stdInput.readLine()) != null) {
               System.out.println(s);
           }
   
	}
	public void downloadFile()throws IOException
	{
		BufferedInputStream in = new BufferedInputStream(new URL("http://206.207.50.7/getvideo").openStream());
		String fileName = "/home/kunal/Desktop/drz.h264";  
		FileOutputStream fos = new FileOutputStream(fileName);  
		int bytee;  
		while((bytee = in.read()) != -1) {  
		    fos.write(bytee);
		}
		fos.close();
	}
}
