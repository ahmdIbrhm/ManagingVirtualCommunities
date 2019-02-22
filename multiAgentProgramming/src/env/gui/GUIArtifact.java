package gui;

import cartago.Artifact;

public class GUIArtifact extends Artifact{
	public GUIArtifact()
	{
		Interface userInterface=new Interface();
		userInterface.setVisible(true);
	}
}
