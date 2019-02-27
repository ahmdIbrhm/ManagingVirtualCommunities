package communities;

import java.util.ArrayList;
import java.util.Map;

import users.User;

public class Voting extends Community {
	private Map<String, ArrayList<String>> map;
	public Voting(String name, User createdBy, ArrayList<String> topics,Map<String, ArrayList<String>> map) 
	{
		super(name, createdBy, topics);
		this.map=map;
	
	}
	public Map<String, ArrayList<String>> getMap() {
		return map;
	}
	@Override
	public String toString() {
		return "Voting [map=" + map + ", getCommunityId()=" + getCommunityId() + ", getName()=" + getName()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getTopics()=" + getTopics() + "]";
	}
	public void setMap(Map<String, ArrayList<String>> map) {
		this.map = map;
	}
	
}
