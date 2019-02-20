package communities;

import java.util.ArrayList;

import cartago.Artifact;
import users.User;

public class Community extends Artifact {
	 private int communityId;
	 private String name;
	 private User createdBy; 
	 private ArrayList <User> members; 
	 private ArrayList <String> topics;
	
	 public Community(int communityId, String name, User createdBy,ArrayList<String> topics) 
	 {
		this.communityId = communityId;
		this.name = name;
		this.createdBy = createdBy;
		members=new ArrayList<User>();
		members.add(createdBy);
		this.topics = topics;
	}
	 
	 
//	 message board that captures the content of community
}
