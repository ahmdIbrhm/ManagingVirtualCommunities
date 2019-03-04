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
	 @Override
	public String toString() {
		 return "Name: "+name+
				 "\n Interests: "+interests;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Community> getOwnedCommunities() {
		return ownedCommunities;
	}
	public void setOwnedCommunities(ArrayList<Community> ownedCommunities) {
		this.ownedCommunities = ownedCommunities;
	}
	public ArrayList<Community> getRegisteredCommunities() {
		return registeredCommunities;
	}
	public void setRegisteredCommunities(ArrayList<Community> registeredCommunities) {
		this.registeredCommunities = registeredCommunities;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	@Override
	public boolean equals(Object obj) {
		if((((User)obj)).getName().equals(this.getName()))
				return true;
		return false;
	}
	
}
