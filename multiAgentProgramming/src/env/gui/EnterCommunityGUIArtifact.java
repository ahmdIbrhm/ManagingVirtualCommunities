package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.tools.GUIArtifact;
import communities.Community;
import communities.Forum;
import communities.Mailbox;
import communities.Voting;
import servers.CommunitiesManager;
import users.User;

public class EnterCommunityGUIArtifact extends GUIArtifact {
	private EnterCommunityInterface display;
	String name;
	public void init(String name) {
		this.name=name;
    	display = new EnterCommunityInterface(name);
		linkActionEventToOp(display.btnEnter,"enterCommunity");
		linkActionEventToOp(display.btnLeave,"leaveCommunity");
		display.setVisible(true);
		this.init();
	}
	@OPERATION void startEnterCommunity(String name)
	{
		init(name);
	}
	@INTERNAL_OPERATION void enterCommunity(ActionEvent ev){
		String communityId=display.comboBox.getSelectedItem().toString();
		for(int i=0;i<CommunitiesManager.communities.size();i++)
		{
			Community community=CommunitiesManager.communities.get(i);
			if(community.getCommunityId().equals(communityId))
			{
				if(community instanceof Voting)
					signal("focusEnterCommunityVoting",community.getCommunityId());
				else if(community instanceof Mailbox)
					{
						signal("focusEnterCommunityMailbox",community.getCommunityId(),name);
					}
				else if(community instanceof Forum)
					signal("focusEnterCommunityForum",community.getCommunityId());
			}
		}
		display.setVisible(false);
    }  
	
	@INTERNAL_OPERATION void leaveCommunity(ActionEvent ev){
		String communityId=display.comboBox.getSelectedItem().toString();
		signal("leaveCommunity",communityId,name);
		display.setVisible(false);
    }  


}
