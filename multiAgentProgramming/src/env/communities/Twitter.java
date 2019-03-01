package communities;

import java.util.ArrayList;

import users.User;

public class Twitter extends SharingInformationService {
	public Twitter(int maximumNumberOfMessages, int messagesPeriod, String communityId, User createdBy,String[] topics) {
		super(maximumNumberOfMessages,messagesPeriod,communityId,createdBy,topics);
	}
}
