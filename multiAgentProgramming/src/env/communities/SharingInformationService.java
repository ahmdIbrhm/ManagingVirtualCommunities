package communities;

import java.util.ArrayList;

import users.User;

public class SharingInformationService extends Community{
	private int maximumNumberOfMessages;
	private int messagesPeriod;
	
	public SharingInformationService(int maximumNumberOfMessages, int messagesPeriod,String communityId, User createdBy,String topic) {
		super(communityId,createdBy,topic);
		this.maximumNumberOfMessages = maximumNumberOfMessages;
		this.messagesPeriod = messagesPeriod;
	}
	
	
}
