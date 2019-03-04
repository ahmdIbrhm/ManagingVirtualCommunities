package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import cartago.INTERNAL_OPERATION;
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
		createCommunityInterface=new CreateMailboxCommunityInterface();
		createCommunityInterface.setVisible(true);
		linkActionEventToOp(createCommunityInterface.btnConfirm,"createCommunity");
		this.init();
	}
	@INTERNAL_OPERATION void createCommunity(ActionEvent ev){
		int maximumNumberOfMessages=(Integer)(createCommunityInterface.spinner.getValue());
		int messagesPeriod=(Integer)(createCommunityInterface.slider.getValue());
		String communityId=createCommunityInterface.textFieldCommunityId.getText();
		User createdBy=CommunitiesManager.getUser(name);
		int topicsIndex=createCommunityInterface.list.getSelectedIndex();
		
		String topic=SignUp.globalInterests[topicsIndex];

		Mailbox mailbox=new Mailbox(maximumNumberOfMessages, messagesPeriod, communityId, createdBy, topic);
		CommunitiesManager.communities.add(mailbox);
		JOptionPane.showMessageDialog(createCommunityInterface, "Added");
		createCommunityInterface.setVisible(false);
    }
}
