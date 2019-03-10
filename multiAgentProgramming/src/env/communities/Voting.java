package communities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;

import users.User;

public class Voting extends Community {
	public static String[] questionTab= {"question1","question2","question3","question4","question5","question6"};
	public static ArrayList<String> question=new ArrayList<String>();
	private String indices;
	public Map<User,ArrayList<Map<String,String>>> map=new HashMap<>();
	public Voting(String communityId, User createdBy, String topic, String indices) 
	{
		super(communityId, createdBy, topic);
		this.indices=indices;
		String delimiter = "\\.";
		for(int i=0;i<indices.split(delimiter).length;i++) {
			question.add(indices.split(delimiter)[i]);
		}
	}
	
	public ArrayList<String> getQuestion() {
		return question;
	}


	public void setQuestion(ArrayList<String> question) {
		this.question = question;
	}


	
	public String diplay() {
		return "Voting [map=" + map + ", getCommunityId()=" + getCommunityId() + ", getCreatedBy()=" + getCreatedBy()
				+ "]";
	}
	
	public String toString() {
		return getCommunityId();
		
	}
	
	
}
