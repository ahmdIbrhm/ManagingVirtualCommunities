// CArtAgO artifact code for project multiAgentProgramming

package gui;

import java.awt.event.ActionEvent;

import cartago.*;
import cartago.tools.GUIArtifact;
import communities.Voting;

public class ChangeIntrestesGUIArtifact extends GUIArtifact {
	ChangeIntrestInterface changeIntrestInterface;
	String name;
	void init(String name) {
		this.name=name;
		changeIntrestInterface=new ChangeIntrestInterface(name);
		changeIntrestInterface.setVisible(true);
		linkActionEventToOp(changeIntrestInterface.btnChange,"updateIntrests");
		this.init();
	}
	@OPERATION 
	void startChangeInterests(String name)
	{
		init(name);
	}
	@INTERNAL_OPERATION void updateIntrests(ActionEvent ev){
		String interests= SignUp.globalInterests[changeIntrestInterface.intrestsList.getSelectedIndices()[0]];
		for(int i=1;i<changeIntrestInterface.intrestsList.getSelectedIndices().length;i++) {
			interests+="."+SignUp.globalInterests[changeIntrestInterface.intrestsList.getSelectedIndices()[i]];
		}
		
		signal("updateIntrests",name,interests);
		changeIntrestInterface.dispose();
	}
}

