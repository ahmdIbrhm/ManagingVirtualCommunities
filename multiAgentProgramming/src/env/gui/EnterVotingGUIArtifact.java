// CArtAgO artifact code for project multiAgentProgramming

package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.*;
import cartago.tools.GUIArtifact;
import communities.Voting;

public class EnterVotingGUIArtifact extends GUIArtifact {
	private EnterVotingInterface display;
	String name;
	String communityId;

	public void init(String name,String communityId) {
    	this.name=name;
    	this.communityId=communityId;
    	display=new EnterVotingInterface(name);
    	display.setVisible(true);
    	linkActionEventToOp(display.btnConfirm,"confirm");
    	linkActionEventToOp(display.btnNext,"next");
    	this.init();

	}

	@OPERATION void startVoting(String name,String communityId) {
    	init(name,communityId);
	}
	@INTERNAL_OPERATION void confirm(ActionEvent ev){
		
		signal("confirm",communityId,name);
	}
	@INTERNAL_OPERATION void next(ActionEvent ev){
		
		
		String response = "";
		if(display.yesRadio.isSelected()) {
			response="yes";
		}else if(display.noRadio.isSelected()) {
			response="no";
		}
		signal("addToMap",communityId,name,Voting.question.get(display.cpt),response);
		display.yesRadio.setSelected(false);
		display.noRadio.setSelected(false);
		
	}
}

