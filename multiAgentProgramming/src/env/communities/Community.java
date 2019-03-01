package communities;

import java.util.ArrayList;

import cartago.Artifact;
import cartago.OPERATION;
import users.User;

public class Community extends Artifact {

	 private String communityId;
	 private User createdBy; 
	 private ArrayList <User> members; 
	 private String[] topics;
	 public Community()
	 {
		 
	 }
	 public Community(String communityId, User createdBy,String[] topics) 
	 {
		this.communityId = communityId;
		this.createdBy = createdBy;
		members=new ArrayList<User>();
		members.add(createdBy);
		this.topics = topics;
	}

	 public void disconnect()
	 {
		 signal("disconnect");
	 }
	 
	 
//	 message board that captures the content of community
}
