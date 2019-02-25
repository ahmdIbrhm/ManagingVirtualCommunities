package communities;

import java.util.ArrayList;
import java.util.Queue;

import users.User;

public class ModeratedForum extends SharingInformationService{
	public ModeratedForum(int maximumNumberOfMessages, int messagesPeriod, int communityId, String name, User createdBy,ArrayList<String> topics) {
		super(maximumNumberOfMessages,messagesPeriod,communityId,name,createdBy,topics);
	}
}
