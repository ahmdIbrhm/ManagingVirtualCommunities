// Agent communityAssitant in project multiAgentProgramming

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
+!sendMessage(CommunityId,UserName,UserTo,Message): idManager(Id) <- sendMessage(CommunityId,UserName,UserTo,Message)[artifact_id(Id)].

+focusOwnedCommunities(UserName) : idOwnedCommunities(Id2) <- focus(Id2);startOwned(UserName).
+focusOwnedCommunities(UserName) <-.concat("ownedCommunities1",UserName,Result);makeArtifact(Result,"gui.OwnedCommunitiesGUIArtifact",[UserName],Id2);focus(Id2);+idOwnedCommunities(Id2).

+leaveCommunity(CommunityId,UserName) <- !leaveCommunity(CommunityId,UserName).
+!leaveCommunity(CommunityId,UserName):idManager(Id) <- leaveCommunity(CommunityId,UserName)[artifact_id(Id)].

+joinedResult(UserId,CommunityId,Result): idShowCommunities(Id3) <-  focus(Id3);resultOfJoiningCommunity(Result).

+deleteCommunity(CommunityId):idManager(Id) <- deleteCommunity(CommunityId,Bool)[artifact_id(Id)];!manageDeleteResult(Bool).
+!manageDeleteResult(Bool):Bool==true <- deleteCommunityResults(true).
+!manageDeleteResult(Bool):Bool==false <- deleteCommunityResults(false).
//--------------- Voting part-------------------------------------
+focusCreateVoting(UserName): idCreateVoting(IdVoting1)<-focus(IdVoting1);startVotingInterface(UserName).
+focusCreateVoting(UserName) <-.concat("createVoting1",UserName,Result);makeArtifact(Result,"gui.CreateVotingCommunityGUIArtifact",[UserName],IdVoting);focus(IdVoting);+idCreateVoting(IdVoting).

+createVoting(CommunityId,CreatedBy,Topic,QuestionsIndices):idManager(Id) <- createVoting(CommunityId, CreatedBy,Topic,QuestionsIndices)[artifact_id(Id)].

+votingCreatedTrue(UserName): userName(Name) & Name=UserName & idCreateVoting(IdVoting1) <- focus(IdVoting1); votingCreatedSuccesfully(true).
+votingCreatedFalse(UserName): userName(Name) & Name=UserName & idCreateVoting(IdVoting1) <- focus(IdVoting1); votingCreatedSuccesfully(false).


+focusEnterCommunityVoting(CommunityId,UserName):idEnterCommunityVoting(IdVoting) <- focus(IdVoting);startVoting(UserName,CommunityId).
+focusEnterCommunityVoting(CommunityId,UserName) <- .concat("enterCommunityVoting1",CommunityId,Result1);.concat(Result1,UserName,Result);makeArtifact(Result,"gui.EnterVotingGUIArtifact",[UserName,CommunityId],IdVoting4);+idEnterCommunityVoting(IdVoting4);focus(IdVoting4).

+addToMap(CommunityId,UserName,Question,Response):idManager(Id) <- addToMap(CommunityId,UserName,Question,Response)[artifact_id(Id)].

+confirm(CommunityId,UserName):idManager(Id) <- confirm(CommunityId,UserName)[artifact_id(Id)].

//--------------- JUST FOR THIS AGENT ---------------------------------
+focusChangeInterests(UserName): idChangeInterests(IdVoting4)<-focus(IdVoting4);startChangeInterests(UserName).
+focusChangeInterests(UserName) <-.concat("changeInterests1",UserName,Result);makeArtifact(Result,"gui.ChangeIntrestesGUIArtifact",[UserName],IdVoting);focus(IdVoting);+idChangeInterests(IdVoting).
+updateIntrests(UserName,Intrests):idManager(Id) <- updateIntrests(UserName,Intrests)[artifact_id(Id)].

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
