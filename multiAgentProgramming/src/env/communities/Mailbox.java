package communities;

import java.util.ArrayList;

import cartago.Artifact;
import cartago.OPERATION;
import users.User;
import utils.Message;

public class Mailbox extends SharingInformationService{

	ArrayList<Message> messages=new ArrayList<Message>();
	public Mailbox(int maximumNumberOfMessages, int messagesPeriod, String communityId, User createdBy,String topic) 
	{
		super(maximumNumberOfMessages,messagesPeriod,communityId,createdBy,topic);
	}
	public void addMessage(Message message) {
		messages.add(message);
	}
	public ArrayList<Message> getMessages(String name)
	{
		ArrayList<Message> myMessages=new ArrayList<Message>();
		for(int i=0;i<messages.size();i++)
		{
			if(messages.get(i).getUserTo().getName().equals(name))
			{
				myMessages.add(messages.get(i));
			}

		}
		return myMessages;
	}
	
}
