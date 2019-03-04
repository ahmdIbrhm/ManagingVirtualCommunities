package communities;

import java.util.ArrayList;

import users.User;

public class Twitter extends SharingInformationService {
	public Twitter(int maximumNumberOfMessages, int messagesPeriod, String communityId, User createdBy,String topic) {
		super(maximumNumberOfMessages,messagesPeriod,communityId,createdBy,topic);
	}
}
