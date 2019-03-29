// Agent serverAgent in project multiAgentProgramming

/* Initial beliefs and rules */

/* Initial goals */

!setup_and_monitor.
/* Plans */
+!setup_and_monitor <-joinWorkspace("sports",Id);!setupArtifacts.
+!setupArtifacts <- makeArtifact("manager", "servers.CommunitiesManager",[],Id);+idManager(Id);focus(Id).
+!sendMessage(CommunityId,From,To,Message): idManager(Id) <- focus(Id);sendMessage(CommunityId,From,To,Message).
+!createMailbox(MaximumNumberOfMessages, MessagesPeriod, CommunityId, CreatedBy, Topic) <- 
					createMailbox(MaximumNumberOfMessages, MessagesPeriod, CommunityId, CreatedBy, Topic).
+!createVoting(CommunityId, CreatedBy, Topic,QuestionsIndices) <-
					createVoting(CommunityId, CreatedBy,Topic,QuestionsIndices).

+!addToMap(CommunityId,UserName,Question,Response) 	<-
					addToMap(CommunityId,UserName,Question,Response).				
+!deleteCommunity(CommunityId) <- deleteCommunity(CommunityId).


+!updateIntrests(UserName,Intrests) <- updateIntrests(UserName,Intrests).

+!confirm(CommunityId,UserName) <- confirm(CommunityId,UserName).

+!leaveCommunity(CommunityId,UserName) <- leaveCommunity(CommunityId,UserName).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
