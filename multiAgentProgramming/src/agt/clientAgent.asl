// Agent clientAgent in project multiAgentProgramming

/* Initial beliefs and rules */

/* Initial goals */

!setup_and_monitor.

/* Plans */

+!setup_and_monitor <- joinWorkspace("sports",Id);!setUpArtifacts.
+!setUpArtifacts <- .my_name(Name);makeArtifact("guiSignUp","gui.SignUpGUIArtifact",[Name],Id2);focus(Id2).

+focusMain(UserName) <- makeArtifact("main1","gui.MainInterfaceGUIArtifact",[UserName],Id1);focus(Id1).
+focusCreateMailbox(UserName) <-makeArtifact("createMailbox1","gui.CreateMailboxCommunityGUIArtifact",[UserName],Id2);focus(Id2).
+focusShowCommunities(UserName) <- makeArtifact("showCommunities1","gui.ShowCommunitiesGUIArtifact",[UserName],Id3);focus(Id3).
+focusEnterCommunity(UserName) <- makeArtifact("enterCommunities1","gui.EnterCommunityGUIArtifact",[UserName],Id7);focus(Id7).


+focusEnterCommunityMailbox(CommunityId,UserName) <- makeArtifact("enterCommunityMailbox1","gui.EnterMailboxGUIArtifact",[UserName,CommunityId],Id4);focus(Id4).
+focusEnterCommunityForum(CommunityId) <- makeArtifact("enterCommunityForum1","gui.AdnansClass",[UserName],Id5);focus(Id5).
+focusEnterCommunityVoting(CommunityId) <- makeArtifact("enterCommunityVoting1","gui.ZemrounsClass",[UserName],Id6);focus(Id6).


+sendMessage(CommunityId,UserName,UserTo,Message)<-.send(serverAgent,tell,message(CommunityId,UserName,UserTo,Message)).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
