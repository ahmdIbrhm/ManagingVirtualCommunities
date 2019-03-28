package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
import cartago.OPERATION;
import cartago.tools.GUIArtifact;
import communities.Mailbox;
import servers.CommunitiesManager;
import users.User;

public class CreateMailboxCommunityGUIArtifact extends GUIArtifact {
	CreateMailboxCommunityInterface createCommunityInterface;
	String name;
	public void init(String name)
	{
		this.name=name;
		createCommunityInterface=new CreateMailboxCommunityInterface(name);
		createCommunityInterface.setVisible(true);
		linkActionEventToOp(createCommunityInterface.btnConfirm,"createCommunity");
		this.init();
	}
	@OPERATION void startInterface(String name)
	{
		init(name);
	}
	@INTERNAL_OPERATION void createCommunity(ActionEvent ev){
		int maximumNumberOfMessages=(Integer)(createCommunityInterface.spinner.getValue());
		int messagesPeriod=(Integer)(createCommunityInterface.slider.getValue());
		String communityId=createCommunityInterface.textFieldCommunityId.getText();
		String createdBy=name;
		User user=CommunitiesManager.getUser(createdBy);
		int topicsIndex=createCommunityInterface.list.getSelectedIndex();
		if(topicsIndex!=-1 && !communityId.trim().equals(""))
		{
			String topic=SignUp.globalInterests[topicsIndex];
			Mailbox mailbox=new Mailbox(maximumNumberOfMessages, messagesPeriod, communityId, user, topic);
			signal("createMailbox",mailbox);
		}
		else
		{
			JOptionPane.showMessageDialog(createCommunityInterface, "Error");
		}
    }
	@OPERATION void mailboxCreatedSuccesfully(boolean ok)
	{
		if(ok)
		{
			JOptionPane.showMessageDialog(createCommunityInterface, "Added");
			createCommunityInterface.setVisible(false);
		}
		else
		{
			JOptionPane.showMessageDialog(createCommunityInterface, "Id already exists");
		}
	}
}
