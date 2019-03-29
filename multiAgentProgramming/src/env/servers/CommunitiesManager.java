package servers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import cartago.Artifact;
import cartago.OPERATION;
import cartago.ObsProperty;
import cartago.OpFeedbackParam;
import communities.Community;
import communities.Forum;
import communities.Mailbox;
import communities.Voting;
import jason.stdlib.println;
import users.User;
import utils.Message;

public class CommunitiesManager extends Artifact{
	public static ArrayList<Community> communities=new ArrayList<Community>();
	public static ArrayList<User> users=new ArrayList<User>();
	
	@OPERATION void sendMessage(String communityId,String from,String to,String message)
	{
		Community community=getCommunity(communityId);
		if(to.equals("All"))
		{
			for(int i=0;i<community.getMembers().size();i++)
			{
				if(!community.getMembers().get(i).getName().equals(from))
					sendMessage(communityId, from, community.getMembers().get(i).getName(), message);
			}
		}
		else
		{
			User userFrom=getUser(from);
			User userTo=getUser(to);
			((Mailbox)(community)).addMessage(new Message(userFrom,userTo,message));
		}
	}

	@OPERATION void enterCommunity(String userId,String communityId)
	{
		boolean userHaveSameInterestAsCommunity=false;
		User user=getUser(userId);
		Community community = getCommunity(communityId);
		if (!userExistInCommunity(user, community)) 
		{
			for (int i = 0; i < user.getInterests().length; i++) 
			{
				if (user.getInterests()[i].equals(community.getTopic())) 
				{
					userHaveSameInterestAsCommunity = true;
				}
			}
			if (userHaveSameInterestAsCommunity) 
			{
				for (int i = 0; i < communities.size(); i++) 
				{
					if (communities.get(i).getCommunityId().equals(communityId)) 
					{
						communities.get(i).getMembers().add(getUser(userId));
						System.out.println("size " + communities.get(i).getMembers().size());
					}
				}
				signal("joinedResult", userId, communityId, "yes");
				if (getCommunity(communityId) instanceof Mailbox) 
				{
					signal("numberOfMembersIncreased", communityId, getCommunity(communityId).getMembers().size());
				}
			} 
			else 
			{
				signal("joinedResult", userId, communityId, "no");
			}
		}
	}
	private boolean userExistInCommunity(User user,Community community)
	{
		for(int i=0;i<community.getMembers().size();i++)
		{
			if(community.getMembers().get(i).getName().equals(user.getName()))
				return true;
		}
		return false;
	}

	@OPERATION void leaveCommunity(String communityId,String userId)
	{
		for(int i=0;i<communities.size();i++)
		{
			if(communities.get(i).getCommunityId().equals(communityId))
			{
				for(int j=0;j<communities.get(i).getMembers().size();j++)
				{
					if(communities.get(i).getMembers().get(j).getName().equals(userId))
					{
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
	@OPERATION void createMailbox(Mailbox mailbox,OpFeedbackParam<Boolean> accepted)
	{
		if(communityNameOk(mailbox.getCommunityId()))
		{
			communities.add(mailbox);
			for(int i=0;i<users.size();i++)
			{
				if(users.get(i).getName().equals(mailbox.getCreatedBy().getName()))
				{
					users.get(i).getOwnedCommunities().add(mailbox);
				}
			}
			accepted.set(true);
			signal("mailboxCreated",mailbox.getCommunityId());
		}
		else
		{
			accepted.set(false);
		}
	}
	@OPERATION void createVoting(String communityId,String userName,String topic,String indices)
	{
		
		
		if(communityNameOk(communityId))
		{
			User createdBy=getUser(userName);
		    Voting voting=new Voting( communityId, createdBy, topic,indices);
			communities.add(voting);
			for(int i=0;i<users.size();i++)
			{
				if(users.get(i).getName().equals(createdBy.getName()))
				{
					users.get(i).getOwnedCommunities().add(voting);
				}
			}
			signal("votingCreatedTrue",userName);
			signal("votingCreated",communityId);
		}
		else
		{
			signal("votingCreatedFalse",userName);
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
	@OPERATION void deleteCommunity(String communityId,OpFeedbackParam<Boolean> accepted)
	{
		Community community = getCommunity(communityId);
		if(community.getMembers().size()<=1)
		{
			community.getCreatedBy().getOwnedCommunities().remove(community);
			communities.remove(community);
			accepted.set(true);
		}
		else
			accepted.set(false);
	}
	@OPERATION void confirm(String communityId,String userName) {
		Voting community =(Voting) getCommunity(communityId);
		System.out.println(community.diplay());
		
	}
	@OPERATION void updateIntrests(String name,String intrests) {
		User user= getUser(name);
		String delimiter = "\\.";
		String[] intrestTab = new String[intrests.split(delimiter).length];
		for(int i=0;i<intrests.split(delimiter).length;i++) {
			intrestTab[i]=intrests.split(delimiter)[i];
		}
		user.setInterests(intrestTab);
		leaveAllCommunities(user);
		
	}
	@OPERATION void addToMap(String communityId,String name,String question,String response)
	{
		Map<String,String> result=new HashMap<String,String>() ;
		result.put(question, response);
		User user= getUser(name);
		Voting community =(Voting) getCommunity(communityId);
		if(community.map.containsKey(user)) {
			community.map.get(user).add(result);
		}
		else {
			community.map.put(user,new ArrayList<Map<String,String>>());
			community.map.get(user).add(result);
		}
		
	}
	
	@OPERATION void addUser(User user, OpFeedbackParam<Boolean> accepted,OpFeedbackParam<String> name)
	{
		if(!users.contains(user))
		{
			users.add(user);
			accepted.set(true);
			name.set(user.getName());
		}
		else 
		{			
			accepted.set(false);
		}
	}
	public void leaveAllCommunities(User user)
	{
		Boolean flag=false;
		for(Community community:getUserCommunities(user.getName())) {
			for(int i=0;i<user.getInterests().length;i++) {
				if(community.getTopic().equals(user.getInterests()[i])) {
					flag=true;
				}
			}
			if(flag==false) {
				leaveCommunity(community.getCommunityId(),user.getName());
			}
			flag=false;
			
		}
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
