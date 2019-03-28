// Agent clientAgent in project multiAgentProgramming

/* Initial beliefs and rules */
/* Initial goals */

!setup_and_monitor.

/* Plans */
+!setup_and_monitor <- joinWorkspace("sports",Id);!setUpArtifacts.
+!setUpArtifacts <- .my_name(Name);.concat("guiSignUp",Name,ArtifactName);makeArtifact(ArtifactName,"gui.SignUpGUIArtifact",[Name],Id1);+signUpArtifactId(Id1);focus(Id1);
	lookupArtifact("manager",Id2);focus(Id2);+idManager(Id2).

+addUser(UserObject): idManager(Id) <- addUser(UserObject,Bool,Name)[artifact_id(Id)];!checkUsername(Bool,Name).
+!checkUsername(Bool,Name): Bool==true <- !focusMain(Name); resultOfSigningUp(true).
+!checkUsername(Bool,Name): Bool==false & signUpArtifactId(Id)<- focus(Id); resultOfSigningUp(false). 


+!focusMain(UserName) <- +userName(UserName).concat("main",UserName,Result);makeArtifact(Result,"gui.MainInterfaceGUIArtifact",[UserName],Id1);focus(Id1).

+focusCreateMailbox(UserName): idCreateMailbox(Id2)<-focus(Id2);startInterface(UserName).
+focusCreateMailbox(UserName) <-.concat("createMailbox1",UserName,Result);makeArtifact(Result,"gui.CreateMailboxCommunityGUIArtifact",[UserName],Id2);focus(Id2);+idCreateMailbox(Id2).

+focusShowCommunities(UserName) :idShowCommunities(Id3) <- focus(Id3);startShowCommunity(UserName).
+focusShowCommunities(UserName) <- .concat("showCommunities1",UserName,Result);makeArtifact(Result,"gui.ShowCommunitiesGUIArtifact",[UserName],Id3);+idShowCommunities(Id3);focus(Id3).

+focusEnterCommunity(UserName) : idEnterCommunity(Id7) <- focus(Id7);startEnterCommunity(UserName).
+focusEnterCommunity(UserName) <- .concat("enterCommunities1",UserName,Result);makeArtifact(Result,"gui.EnterCommunityGUIArtifact",[UserName],Id7);+idEnterCommunity(Id7);focus(Id7).

+focusEnterCommunityMailbox(CommunityId,UserName):idEnterCommunityMailbox(Id) <- focus(Id);start(UserName,CommunityId).
+focusEnterCommunityMailbox(CommunityId,UserName) <- .concat("enterCommunityMailbox1",CommunityId,Result1);.concat(Result1,UserName,Result);makeArtifact(Result,"gui.EnterMailboxGUIArtifact",[UserName,CommunityId],Id4);+idEnterCommunityMailbox(Id4);focus(Id4).

+createMailbox(Mailbox): idManager(Id) <- createMailbox(Mailbox,Bool)[artifact_id(Id)];!resultsCreatingMailbox(Bool).
+!resultsCreatingMailbox(Bool) :Bool==true & idCreateMailbox(Id) <- mailboxCreatedSuccesfully(true)[artifact_id(Id)].
+!resultsCreatingMailbox(Bool) :Bool==false & idCreateMailbox(Id) <- mailboxCreatedSuccesfully(false)[artifact_id(Id)].

+addToCommunity(UserName,CommunityId)<- !addToCommunity(UserName,CommunityId).
+!addToCommunity(UserName,CommunityId): idManager(Id) <- addToCommunity(UserName,CommunityId)[artifact_id(Id)].

+sendMessage(CommunityId,UserName,UserTo,Message)<-!sendMessage(CommunityId,UserName,UserTo,Message).
+!sendMessage(CommunityId,UserName,UserTo,Message) <- .send(serverAgent,achieve,sendMessage(CommunityId,UserName,UserTo,Message)).

+focusOwnedCommunities(UserName) : idOwnedCommunities(Id2) <- focus(Id2);startOwned(UserName).
+focusOwnedCommunities(UserName) <-.concat("ownedCommunities1",UserName,Result);makeArtifact(Result,"gui.OwnedCommunitiesGUIArtifact",[UserName],Id2);focus(Id2);+idOwnedCommunities(Id2).

+leaveCommunity(CommunityId,UserName) <- !leaveCommunity(CommunityId,UserName).
+!leaveCommunity(CommunityId,UserName):idManager(Id) <- leaveCommunity(CommunityId,UserName)[artifact_id(Id)].

+joinedResult(UserId,CommunityId,Result): idShowCommunities(Id3) <-  focus(Id3);resultOfJoiningCommunity(Result).

+deleteCommunity(CommunityId):idManager(Id) <- deleteCommunity(CommunityId,Bool)[artifact_id(Id)];!manageDeleteResult(Bool).
+!manageDeleteResult(Bool):Bool==true <- deleteCommunityResults(true).
+!manageDeleteResult(Bool):Bool==false <- deleteCommunityResults(false).

//--------------- JUST FOR THIS AGENT ---------------------------------

+mailboxCreated(MailboxId):userName(MyName) <-!addToCommunity(MyName,MailboxId).

+numberOfMembersIncreased(CommunityId,Number): Number > 2 <- !sayHelloToAllAndExit(CommunityId).
+!sayHelloToAllAndExit(MailboxId): userName(MyName) <- !sendMessage(MailboxId,MyName,"All","Hello");!leaveCommunity(MailboxId,MyName).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
