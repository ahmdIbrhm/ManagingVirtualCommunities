// CArtAgO artifact code for project multiAgentProgramming

package gui;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cartago.*;
import cartago.tools.GUIArtifact;
import communities.Voting;

public class CreateVotingCommunityGUIArtifact extends GUIArtifact {
	CreateVotingCommunityInterface createCommunityInterface;
	String name;
	void init(String name) {
		this.name=name;
		createCommunityInterface=new CreateVotingCommunityInterface(name);
		createCommunityInterface.setVisible(true);
		linkActionEventToOp(createCommunityInterface.btnConfirm,"createCommunity");
		this.init();
	}
	@OPERATION 
	void startVotingInterface(String name)
	{
		init(name);
	}
	@INTERNAL_OPERATION void createCommunity(ActionEvent ev){
		String communityId=createCommunityInterface.textFieldCommunityId.getText();
		String createdBy=name;
		int topicsIndex=createCommunityInterface.topicsList.getSelectedIndex();
		String questionsIndices=Voting.questionTab[createCommunityInterface.questionList.getSelectedIndices()[0]];
		for(int i=1;i<createCommunityInterface.questionList.getSelectedIndices().length;i++) {
			questionsIndices+="."+Voting.questionTab[createCommunityInterface.questionList.getSelectedIndices()[i]];
		}
		if(topicsIndex!=-1 && !communityId.trim().equals(""))
		{
			
			String topic=SignUp.globalInterests[topicsIndex];
			signal("createVoting",communityId,createdBy,topic,questionsIndices);
			
		}
		else
		{
			JOptionPane.showMessageDialog(createCommunityInterface, "Error");
		}
		
    }
	@OPERATION void votingCreatedSuccesfully(boolean ok)
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

