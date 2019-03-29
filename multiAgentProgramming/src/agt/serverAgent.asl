/* Initial beliefs and rules */

/* Initial goals */

!setup_and_monitor.
/* Plans */
+!setup_and_monitor <-joinWorkspace("sports",Id);!setupArtifacts.
+!setupArtifacts <- makeArtifact("manager", "servers.CommunitiesManager",[],Id);+idManager(Id);focus(Id).
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
