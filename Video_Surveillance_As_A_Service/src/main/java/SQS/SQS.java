package SQS;

import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SQS {

	public AmazonSQS getSQSobject()
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
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.US_WEST_1)
                .build();
		return sqs;
	}	
	public void sendMessage(String str)
	{
		AmazonSQS sqs=getSQSobject();
		List<String> queueUrls= sqs.listQueues().getQueueUrls();
		String queueUrl=queueUrls.get(0);
		System.out.println("Hey its this queue==="+queueUrl);
		sqs.sendMessage(new SendMessageRequest(queueUrl, str));
		System.out.println("Message sent in the queue");
	}
	public void deleteMessage()
	{
		AmazonSQS sqs=getSQSobject();
		List<String> queueUrls= sqs.listQueues().getQueueUrls();
		String queueUrl=queueUrls.get(0);
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
        String messageReceiptHandle = messages.get(0).getReceiptHandle();
        sqs.deleteMessage(new DeleteMessageRequest(queueUrl, messageReceiptHandle));
        System.out.println("Message  '"+messageReceiptHandle+" ' has been deleted");
	}

}
