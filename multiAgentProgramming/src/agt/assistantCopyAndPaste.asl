// Agent communityAssitant_Ahmad in project multiAgentProgramming

/* Initial beliefs and rules */

/* Initial goals */


!setup_and_monitor.

/* Plans */

+!setup_and_monitor <-joinWorkspace("sports",Id);!setupArtifacts.
+!setupArtifacts <-.my_name(Name); makeArtifact("gui","gui.SignUpGUIArtifact",[Name],Id2);focus(Id2).

+focusMain(UserName) <- makeArtifact("main2","gui.MainInterfaceGUIArtifact",[UserName],Id1);focus(Id1).
+focusCreateMailbox(UserName) <-makeArtifact("createMailbox2","gui.CreateMailboxCommunityGUIArtifact",[UserName],Id2);focus(Id2).
+focusShowCommunities(UserName) <- makeArtifact("showCommunities2","gui.ShowCommunitiesGUIArtifact",[UserName],Id3);focus(Id3).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
