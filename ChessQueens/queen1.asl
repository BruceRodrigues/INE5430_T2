/* Initial beliefs and rules */
pos(queen1, 1, 1).

start.

/* Plans */
+start <-
	+getPositionOf(queen2).

+getPositionOf(Q) <-
	.send(Q, askOne, pos(Q, A, B), pos(Q, A, B));
	+pos(Q, A, B);
	-getPositionOf(Q). // As we cant be sure that this will remain true...

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

