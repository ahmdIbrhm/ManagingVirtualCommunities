package communities;

import java.util.ArrayList;
import java.util.Queue;

import users.User;

public class ModeratedForum extends SharingInformationService{
	public ModeratedForum(int maximumNumberOfMessages, int messagesPeriod, String communityId, User createdBy,String topic) {
		super(maximumNumberOfMessages,messagesPeriod,communityId,createdBy,topic);
	}
}
