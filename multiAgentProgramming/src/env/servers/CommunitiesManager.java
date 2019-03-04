package servers;

import java.util.ArrayList;
import cartago.Artifact;
import cartago.OPERATION;
import communities.Community;
import communities.Mailbox;
import users.User;
import utils.Message;

public class CommunitiesManager extends Artifact{
	public static ArrayList<Community> communities=new ArrayList<Community>();
	public static ArrayList<User> users=new ArrayList<User>();
	
	public static void addCommunity(Community community)
	{
		communities.add(community);
	}
	@OPERATION void showCommunities()
	{
		System.out.println("Communities");
	}
	@OPERATION void sendMessage(String communityId,String from,String to,String message)
	{
		User userFrom=getUser(from);
		User userTo=getUser(to);
		Community community=getCommunity(communityId);
		((Mailbox)(community)).addMessage(new Message(userFrom,userTo,message));
	}
	
	public static User getUser(String name)
	{
		for(int i=0;i<users.size();i++)
		{
			if(users.get(i).getName().equals(name))
			{
				return users.get(i);
			}
		}
		return null;
	}
	
	public static void addUser(User user)
	{
		users.add(user);
	}
	public static ArrayList<Community> getUserCommunities(String name)
	{
		ArrayList<Community> communitiesList=new ArrayList<Community>();
		User user=getUser(name);
		for(int i=0;i<communities.size();i++)
		{
			if(communities.get(i).getMembers().contains(user))
			{
				communitiesList.add(communities.get(i));
			}
		}
		return communitiesList;
	}
	public static Community getCommunity(String communityId)
	{
		for(int i=0;i<communities.size();i++)
		{
			if(communities.get(i).getCommunityId().equals(communityId))
				return communities.get(i);
		}
		return null;
	}
	
	public static ArrayList<Message> getMessagesForUserInMailbox(String communityId,String userName)
	{
		for(int i=0;i<communities.size();i++)
		{
			if(communities.get(i).getCommunityId().equals(communityId))
			{
				return ((Mailbox)communities.get(i)).getMessages(userName);
			}
		}
		return null;
	}
}
