package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
import cartago.tools.GUIArtifact;
import servers.CommunitiesManager;
import users.User;

public class ShowCommunitiesGUIArtifact extends GUIArtifact {
	ShowCommunitiesInterface display;
	private String name;
	public void init(String name) {
		this.name=name;
    	display = new ShowCommunitiesInterface(name);
		linkActionEventToOp(display.btnJoinCommunity,"joinCommunity");
		display.setVisible(true);
		this.init();
	}
	@INTERNAL_OPERATION void joinCommunity(ActionEvent ev){
		String commmunityId=display.comboBox.getSelectedItem().toString();
		for(int i=0;i<CommunitiesManager.communities.size();i++)
		{
			if(CommunitiesManager.communities.get(i).getCommunityId().equals(commmunityId))
			{
				CommunitiesManager.communities.get(i).getMembers().add(CommunitiesManager.getUser(name));
				System.out.println(CommunitiesManager.communities.get(i).getMembers());
				JOptionPane.showMessageDialog(display.contentPane,"Joined");
			}
		}
    }
}
