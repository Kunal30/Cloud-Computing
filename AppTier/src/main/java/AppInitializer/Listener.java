package AppInitializer;

import SQS.SQS;

public class Listener {

	public void listen_and_giveOutput()
	{
		System.out.println("Listening!!!!!!!");
		SQS sqs=new SQS();
		while(true)
		{
			sqs.receiveMessages();
			System.out.println("Listening!!!!!!!");
		}
	}
}
