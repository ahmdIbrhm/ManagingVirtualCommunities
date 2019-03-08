package servers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import cartago.Artifact;
import cartago.OPERATION;
import cartago.ObsProperty;
import communities.Community;
import communities.Forum;
import communities.Mailbox;
import communities.Voting;
import users.User;
import utils.Message;

public class CommunitiesManager extends Artifact{
	public static ArrayList<Community> communities=new ArrayList<Community>();
	public static ArrayList<User> users=new ArrayList<User>();
	
	public void addCommunity(Community community)
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

	@OPERATION void enterCommunity(String userId,String communityId)
	{
		for(int i=0;i<communities.size();i++)
		{
			if(communities.get(i).getCommunityId().equals(communityId))
			{
				communities.get(i).getMembers().add(getUser(userId));
			}
		}
	}
	@OPERATION void leaveCommunity(String communityId,String userId)
	{
		System.out.println(userId);
		System.out.println(communityId);
		
		for(int i=0;i<communities.size();i++)
		{
			if(communities.get(i).getCommunityId().equals(communityId))
			{
				for(int j=0;j<communities.get(i).getMembers().size();j++)
				{
					if(communities.get(i).getMembers().get(j).getName().equals(userId))
					{
						System.out.println(communities.get(i));
						communities.get(i).getMembers().remove(j);
					}
				}
			}
		}
		for(int i=0;i<users.size();i++)
		{
			if (users.get(i).getName().contentEquals(userId))
			{
				for(int j=0;j<users.get(i).getRegisteredCommunities().size();j++)
				{
					if(users.get(i).getRegisteredCommunities().get(j).getCommunityId().equals(communityId))
					{
						users.get(i).getRegisteredCommunities().remove(j);
					}
				}
			}
		}
		
	}
	@OPERATION void createMailbox(int maximumNumberOfMessages,int messagesPeriod,String communityId,String userName,String topic)
	{
		if(communityNameOk(communityId))
		{
			User createdBy=getUser(userName);
			Mailbox mailbox=new Mailbox(maximumNumberOfMessages, messagesPeriod, communityId, createdBy, topic);
			communities.add(mailbox);
			for(int i=0;i<users.size();i++)
			{
				if(users.get(i).getName().equals(createdBy.getName()))
				{
					users.get(i).getOwnedCommunities().add(mailbox);
				}
			}
			signal("mailboxCreatedTrue",userName);
		}
		else
		{
			signal("mailboxCreatedFalse",userName);
		}		
	}
	public boolean communityNameOk(String name)
	{
		for(int i=0;i<communities.size();i++)
		{
			if(communities.get(i).getCommunityId().equals(name))
				return false;
		}
		return true;
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
	@OPERATION void deleteCommunity(String communityId)
	{
		Community community = getCommunity(communityId);
		community.getCreatedBy().getOwnedCommunities().remove(community);
		communities.remove(community);
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
	
	public static ArrayList<Community> getOwnedCommunities(String name)
	{
		return getUser(name).getOwnedCommunities();
	}
	
	public static ArrayList<Message> getMessagesForUserInMailbox(String communityId,String userName)
	{
		Mailbox mailbox=(Mailbox)getCommunity(communityId);
		return mailbox.getMessages(userName);
	}
	@OPERATION void addToCommunity(String user,String communityId)
	{
		for(int i=0;i<communities.size();i++)
		{
			Community community=communities.get(i);
			if(community.getCommunityId().equals(communityId))
			{
				if(community instanceof Voting)
				{
					
				}
				else if(community instanceof Mailbox)
				{
					enterCommunity(user, communityId);
				}
				else if(community instanceof Forum)
				{
					
				}
			}
		}

	}
	public static ArrayList<Community> getUnjoinedCommunities(String userName) {
		ArrayList<Community> unjoinedCommunities=new ArrayList<Community>();
		for(int i=0;i<communities.size();i++)
		{
			boolean exist=false;
			for(int j=0;j<communities.get(i).getMembers().size();j++)
			{
				if(communities.get(i).getMembers().get(j).getName().equals(userName))
				{
					exist=true;
				}
			}
			if(!exist)
				unjoinedCommunities.add(communities.get(i));
		}
		return unjoinedCommunities;
	}
}
