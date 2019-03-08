package gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.tools.GUIArtifact;
import servers.CommunitiesManager;
import users.User;
import utils.Message;

public class EnterMailboxGUIArtifact extends GUIArtifact {
private EnterMailboxInterface display;
	String name;
	String communityId;
	String messages;
	public void init(String name,String communityId) {
    	this.name=name;
    	this.communityId=communityId;
		display = new EnterMailboxInterface(name,communityId);
		linkActionEventToOp(display.btnSendMessage,"sendMessage");
		display.setVisible(true);
		initializeMessages(communityId, name);
		this.init();
	}
	@OPERATION void start(String name,String communityId) {
    	init(name,communityId);
	}
	
	@INTERNAL_OPERATION void sendMessage(ActionEvent ev){
		String userTo=display.comboBox.getSelectedItem().toString();
		String message=display.textArea.getText();
		signal("sendMessage",communityId,name,userTo,message);
		JOptionPane.showMessageDialog(display, "Sent");
		display.setVisible(false);
	}
	private void initializeMessages(String communityId,String userName)
	{
		ArrayList<Message> messages=CommunitiesManager.getMessagesForUserInMailbox(communityId, userName);
		String messagesString=parseMessages(messages);
		display.textPane.setText(messagesString);
	}
	private String parseMessages(ArrayList<Message> messages)
	{
		System.out.println("Hello");
		String returnedMessage="";
		for(int i=0;i<messages.size();i++)
		{
			returnedMessage+="From: "+messages.get(i).getUserFrom().getName();
			returnedMessage+="\nMessage: "+messages.get(i).getMessage();
			returnedMessage+="\n-------------------------------------------";
		}
		return returnedMessage;
	}
}
