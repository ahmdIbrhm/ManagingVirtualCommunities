package users;

import java.util.ArrayList;

import cartago.Artifact;
import communities.Community;

public class User extends Artifact{
	 private String name;
	 private ArrayList <Community> ownedCommunities;
	 private ArrayList <Community> registeredCommunities;
	 private String[] interests;
	public User(String name, String []interests) 
	{
		this.name = name;
		this.ownedCommunities = new ArrayList<Community>();
		this.registeredCommunities = new ArrayList<Community>();
		this.interests = interests;
	}
	 
	 
}
