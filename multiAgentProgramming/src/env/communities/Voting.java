package communities;

import java.util.ArrayList;
import java.util.Map;

import users.User;

public class Voting extends Community {
	private Map<String, ArrayList<String>> map;
	public Voting(String communityId, User createdBy, ArrayList<String> topics, Map<String, ArrayList<String>> map) 
	{
		super(communityId, createdBy, topics);
		this.map=map;
	}
	public Map<String, ArrayList<String>> getMap() {
		return map;
	}
	public void setMap(Map<String, ArrayList<String>> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "Voting [map=" + map + ", getCommunityId()=" + getCommunityId() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getTopics()=" + getTopics() + "]";
	}
	
	
}
