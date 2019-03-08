package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.tools.GUIArtifact;
import servers.CommunitiesManager;

public class OwnedCommunitiesGUIArtifact extends GUIArtifact {
	OwnedCommunitiesInterface display;
	private String name;
	public void init(String name) {
		this.name=name;
    	display = new OwnedCommunitiesInterface(name);
		linkActionEventToOp(display.btnDelete,"deleteCommunity");
		display.setVisible(true);
		this.init();
	}
	@OPERATION void startOwned(String name)
	{
		init(name);
	}
	
	@INTERNAL_OPERATION void deleteCommunity(ActionEvent ev){
		String communityId=display.comboBox.getSelectedItem().toString();
		int selectedIndex=display.comboBox.getSelectedIndex();
		display.comboBox.removeItemAt(selectedIndex);
		if(CommunitiesManager.getCommunity(communityId).getMembers().size()<=1)
			signal("deleteCommunity",communityId);
		else
			JOptionPane.showMessageDialog(display, "Can't delete, the community has "+CommunitiesManager.getCommunity(communityId).getMembers().size()+ " members");
    }
}
