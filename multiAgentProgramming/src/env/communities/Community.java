package communities;

import java.util.ArrayList;

import cartago.Artifact;
import users.User;

public class Community extends Artifact {

	 private int communityId;
	 private int cpt=0;
	 private String name;
	 private User createdBy; 
	 private ArrayList <User> members; 
	 public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public ArrayList<User> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}
	public ArrayList<String> getTopics() {
		return topics;
	}
	public void setTopics(ArrayList<String> topics) {
		this.topics = topics;
	}
	private ArrayList <String> topics;
	 public Community()
	 {
		 
	 }
	 public Community(int communityId, String name, User createdBy,ArrayList<String> topics) 
	 {
		this.communityId = communityId;
		this.name = name;
		this.createdBy = createdBy;
		members=new ArrayList<User>();
		members.add(createdBy);
		this.topics = topics;
	}
	 public Community(String name, User createdBy,ArrayList<String> topics) 
	 {
		cpt++;
		this.communityId = cpt;
		this.name = name;
		this.createdBy = createdBy;
		members=new ArrayList<User>();
		members.add(createdBy);
		this.topics = topics;
	}
	 
	 
//	 message board that captures the content of community
}
