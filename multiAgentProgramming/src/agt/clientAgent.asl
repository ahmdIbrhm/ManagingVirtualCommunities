// Agent clientAgent in project multiAgentProgramming

/* Initial beliefs and rules */

/* Initial goals */

!setup_and_monitor.

/* Plans */

+!setup_and_monitor <-createWorkspace("client"); joinWorkspace("client",Id);!setupArtifacts.
+!setupArtifacts <- makeArtifact("gui", "gui.GUIArtifact",[],Id);focus(Id);
					makeArtifact("community","communities.Mailbox",[],Id1);focus(Id1).

//+!sayHi <- .send(serverAgent,tell,hi).
+disconnect<-print("Disconnet").

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
