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
	 public Community(String communityId, User createdBy,String topic) 
	 {
		this.communityId = communityId;
		this.createdBy = createdBy;
		members=new ArrayList<User>();
		members.add(createdBy);
		this.topic = topic;
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
		public String getTopic() {
			return topic;
		}
		public void setTopic(String topic) {
			this.topic = topic;
		}
		public ArrayList<User> getMembers() {
			return members;
		}
		@Override
		public String toString() {
			return communityId;
		}
		public String getDescription()
		{
			String s= communityId+" community has "+getTopic()+" as it's topic.";
			s+="\n It contains "+getMembers().size()+" members: ";
			s+="\n "+getMembers();
			return s;
		}
	 
//	 message board that captures the content of community
}
