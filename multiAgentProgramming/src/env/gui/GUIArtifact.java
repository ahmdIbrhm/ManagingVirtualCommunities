package gui;

import cartago.Artifact;

public class GUIArtifact extends Artifact{
	public GUIArtifact()
	{
		SignUp userInterface=new SignUp();
		userInterface.setVisible(true);
	}
}
