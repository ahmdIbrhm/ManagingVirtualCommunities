package communities;

import java.util.ArrayList;

import cartago.Artifact;
import cartago.OPERATION;
import users.User;

public class Community extends Artifact {

	

	 private String communityId;
	 private User createdBy; 
	 private ArrayList <User> members; 
	 private String topic;
	 public Community()
	 {
		 
	 }
	 public Community(String communityId, User createdBy,String topics) 
	 {
		this.communityId = communityId;
		this.createdBy = createdBy;
		members=new ArrayList<User>();
		members.add(createdBy);
		this.topic = topics;
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
		public String getTopics() {
			return topic;
		}
		public void setTopics(String topics) {
			this.topic = topics;
		}
		public ArrayList<User> getMembers() {
			return members;
		}
		@Override
		public String toString() {
			return communityId;
		}
	 
//	 message board that captures the content of community
}
