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
		signal("deleteCommunity",communityId);
			
    }
	@OPERATION void deleteCommunityResults(boolean bool)
	{
		if(bool)
		{
			int selectedIndex=display.comboBox.getSelectedIndex();
			display.comboBox.removeItemAt(selectedIndex);
			JOptionPane.showMessageDialog(display, "Deleted");
		}
		else
			JOptionPane.showMessageDialog(display, "Can't delete, the community has more than 1 member");
	}
}
