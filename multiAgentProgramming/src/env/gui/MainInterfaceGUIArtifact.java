package gui;

import cartago.*;
import cartago.tools.GUIArtifact;
import servers.CommunitiesManager;

import java.awt.event.ActionEvent;
public class MainInterfaceGUIArtifact extends GUIArtifact {
	private MainInterface display;
	private String name;
	public void init(String name) {
		this.name=name;
    	display = new MainInterface(name);
		linkActionEventToOp(display.btnShowCommunities,"showCommunities");
		linkActionEventToOp(display.btnCreateMailbox,"createMailbox");
		linkActionEventToOp(display.btnCreateVoting,"createVoting");
		linkActionEventToOp(display.btnEnterCommunity,"myCommunities");
		linkActionEventToOp(display.btnOwnedCommunities,"ownedCommunities");
		display.setVisible(true);
		this.init();
	}
	
	@INTERNAL_OPERATION void showCommunities(ActionEvent ev){
		signal("focusShowCommunities",name);
    }
	
	@INTERNAL_OPERATION void createMailbox(ActionEvent ev){
		signal("focusCreateMailbox",name);
    }
	@INTERNAL_OPERATION void createVoting(ActionEvent ev){
		signal("focusCreateVoting",name);
    }
	@INTERNAL_OPERATION void myCommunities(ActionEvent ev){
		signal("focusEnterCommunity",name);
    }
	@INTERNAL_OPERATION void ownedCommunities(ActionEvent ev){
		signal("focusOwnedCommunities",name);
    }
}
