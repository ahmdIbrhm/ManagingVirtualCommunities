package communities;

import java.util.ArrayList;

import users.User;

public class Voting extends Community {
	public Voting(String communityId, User createdBy, String[] topics) 
	{
		super(communityId, createdBy, topics);
	}
}
