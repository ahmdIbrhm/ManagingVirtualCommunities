package communities;

import java.util.ArrayList;

import cartago.Artifact;
import cartago.OPERATION;
import users.User;

public class Mailbox extends SharingInformationService{

	public Mailbox(int maximumNumberOfMessages, int messagesPeriod, String communityId, User createdBy,String topic) 
	{
		super(maximumNumberOfMessages,messagesPeriod,communityId,createdBy,topic);
	}
}
