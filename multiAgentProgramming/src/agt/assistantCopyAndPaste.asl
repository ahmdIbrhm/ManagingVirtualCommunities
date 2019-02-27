// Agent communityAssitant_Ahmad in project multiAgentProgramming

/* Initial beliefs and rules */

/* Initial goals */


!setup_and_monitor.

/* Plans */

+!setup_and_monitor <-createWorkspace("server"); joinWorkspace("server",Id);!setupArtifacts.

+!setupArtifacts <- makeArtifact("ahmad", "gui.GUIArtifact",[],Id);focus(Id);print(Id).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
