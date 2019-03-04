package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
import cartago.tools.GUIArtifact;
import servers.CommunitiesManager;
import users.User;

public class SignUpGUIArtifact extends GUIArtifact {
	private SignUp display;
	
	public void init(String name) {
    	display = new SignUp(name);
		linkActionEventToOp(display.btnSignUp,"signUp");
		display.setVisible(true);
		this.init();
	}
	
	@INTERNAL_OPERATION void signUp(ActionEvent ev){
		String name=display.textFieldName.getText();
		int [] interestsIndexes=display.list.getSelectedIndices();
		String [] interests=new String [interestsIndexes.length];
		for(int i=0;i<interests.length;i++)
		{
			interests[i]=SignUp.globalInterests[interestsIndexes[i]];
		}
		if(!name.trim().equals("") && interestsIndexes.length!=0)
		{
			CommunitiesManager.addUser(new User(name,interests));
			signal("focusMain",name);
		}
		else
		{
			JOptionPane.showMessageDialog(display.contentPane, "Error");
		}
    }  
}
