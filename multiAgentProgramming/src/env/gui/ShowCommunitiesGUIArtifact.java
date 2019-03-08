package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
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
	@OPERATION void startShowCommunity(String name)
	{
		init(name);
	}
	@INTERNAL_OPERATION void joinCommunity(ActionEvent ev){
		String communityId=display.comboBox.getSelectedItem().toString();
		signal("addToCommunity",name,communityId);
		display.setVisible(false);
    }
	@OPERATION void resultOfJoiningCommunity(String result)
	{
		if(result.equals("yes"))
			JOptionPane.showMessageDialog(display, "Joined");
		else if(result.equals("no"))
			JOptionPane.showMessageDialog(display, "Can't join, different interests!");
		else
			JOptionPane.showMessageDialog(display, "What happened?");
	}
}
