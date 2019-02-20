package communities;

import java.util.ArrayList;

import users.User;

public class Mailbox extends SharingInformationService{

	public Mailbox(int maximumNumberOfMessages, int messagesPeriod, int communityId, String name, User createdBy,ArrayList<String> topics) {
		super(maximumNumberOfMessages,messagesPeriod,communityId,name,createdBy,topics);
	}
}
