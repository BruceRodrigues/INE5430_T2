/* Initial beliefs and rules */
pos(queen2, 1, 1).

start.

/* Plans */
+start <-
	.send(queen1, askOne, pos(queen1, A, B), pos(queen1, Y, Z)).

//	queenActions.shouldIMove(X);
//	-iDontKnowIfThereIsSomeoneInMyLine;
//	+iAmAlmostSureThereIsNoOneInMyLine.

//+iAmAlmostSureThereIsNoOneInMyLine <-
	
//-weShouldOrganizeVertically : not queenActions.weAreOrganizedVertically <-
//	.print("It seems that we are NOT organized vertically.");
//	+weShouldOrganizeVertically.
//-weShouldOrganizeVertically : queenActions.weAreOrganizedVertically <-
//	.print("It seems that we are organized vertically.");
//	+weShouldOrganizeHorizontally.

//+otherQueensDoesntKnowWhereIAm <-
//	.broadcast(tell, maybeShouldMove);
//	-otherQueensDoesntKnowWhereIAm.

//+maybeShouldMove[source(A)] : queenActions.shouldIMove(A) <-
//	-maybeShouldMove[source(A)];
//	+otherQueensDoesntKnowWhereIAm.
//+maybeShouldMove[source(A)] : not queenActions.shouldIMove(A) <-
//	.print("I will not move!");
//	-maybeShouldMove[source(A)].

