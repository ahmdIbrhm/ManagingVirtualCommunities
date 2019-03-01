package servers;

import java.util.ArrayList;

import cartago.Artifact;
import communities.Community;

public class CommunitiesManager extends Artifact{
	public ArrayList<Community> communities;
	public CommunitiesManager()
	{
		this.communities=new ArrayList<Community>();
	}
	public ArrayList<Community> getCommmunities()
	{
		return this.communities;
	}
}
