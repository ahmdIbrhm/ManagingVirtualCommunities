package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
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
		display.setVisible(true);
		this.init();
	}
	@INTERNAL_OPERATION void enterCommunity(ActionEvent ev){
		String communityId=display.comboBox.getSelectedItem().toString();
		for(int i=0;i<CommunitiesManager.communities.size();i++)
		{
			Community community=CommunitiesManager.communities.get(i);
			System.out.println(community);
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
    }  


}
