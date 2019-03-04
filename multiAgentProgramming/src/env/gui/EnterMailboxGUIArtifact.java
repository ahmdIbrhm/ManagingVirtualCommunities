package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
import cartago.tools.GUIArtifact;
import servers.CommunitiesManager;
import users.User;

public class EnterMailboxGUIArtifact extends GUIArtifact {
private EnterMailboxInterface display;
	String name;
	String communityId;
	public void init(String name,String communityId) {
    	this.name=name;
    	this.communityId=communityId;
		display = new EnterMailboxInterface(name,communityId);
		linkActionEventToOp(display.btnSendMessage,"sendMessage");
		display.setVisible(true);
		this.init();
	}
	
	@INTERNAL_OPERATION void sendMessage(ActionEvent ev){
		String userTo=display.comboBox.getSelectedItem().toString();
		String message=display.textArea.getText();
		signal("sendMessage",communityId,name,userTo,message);
		JOptionPane.showMessageDialog(display, "Sent");
		display.setVisible(false);
	}

}
