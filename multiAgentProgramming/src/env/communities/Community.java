package communities;

import java.util.ArrayList;

import cartago.Artifact;
import cartago.OPERATION;
import users.User;

public class Community extends Artifact {

	

	 private String communityId;
	 private User createdBy; 
	 private ArrayList <User> members; 
	 private ArrayList<String> topics;
	 public Community()
	 {
		 
	 }
	 public Community(String communityId, User createdBy,ArrayList<String> topics) 
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
	 public String getCommunityId() {
			return communityId;
		}
		public void setCommunityId(String communityId) {
			this.communityId = communityId;
		}
		public User getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(User createdBy) {
			this.createdBy = createdBy;
		}
		public ArrayList<String> getTopics() {
			return topics;
		}
		public void setTopics(ArrayList<String> topics) {
			this.topics = topics;
		}
	 
//	 message board that captures the content of community
}
