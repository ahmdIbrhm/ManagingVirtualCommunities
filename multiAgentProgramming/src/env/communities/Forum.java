package communities;

import java.util.ArrayList;

import users.User;

public class Forum extends SharingInformationService{
	public Forum(int maximumNumberOfMessages, int messagesPeriod, int communityId, String name, User createdBy,ArrayList<String> topics) {
		super(maximumNumberOfMessages,messagesPeriod,communityId,name,createdBy,topics);
	}
}
