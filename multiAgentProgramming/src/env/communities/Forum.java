package communities;

import java.util.ArrayList;

import users.User;

public class Forum extends SharingInformationService{
	public Forum(int maximumNumberOfMessages, int messagesPeriod, String communityId, User createdBy,String topic) {
		super(maximumNumberOfMessages,messagesPeriod,communityId,createdBy,topic);
	}
}
