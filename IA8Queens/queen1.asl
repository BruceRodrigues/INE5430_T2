/* Initial beliefs and rules */
iShouldChangeMyPos.
iShouldChangeMyVerticalPos.

/* Initial goals */
!start.

/* Plans */
+!start : true <-
	updatePerceptions.

+weShouldRestart <-
	.print("Our solution seems wrong. Lets try again.");
	-someoneHasFixedColumn;
	-everyoneInPlace;
	-weShouldRestart;
	-~iAmInVerticalDanger[source(percept)];
	+iShouldChangeMyVerticalPos;
	+iAmInVerticalDanger[source(percept)].

+everyoneInPlace : not weShouldRestart <-
	testIfWeShouldRestart;
	-waitForOthers;
	-everyoneInPlace.
-everyoneInPlace : not weShouldRestart <-
	+everyoneInPlace.

+waitForOthers : not everyoneInPlace <-
	testIfEveryoneIsInPlace;
	-waitForOthers.
-waitForOthers : not everyoneInPlace <-
	+waitForOthers.

+someoneHasFixedColumn[source(A)] <-
	-someoneHasFixedColumn;
	.print("congrats, ", A, " :)").

+~iAmInVerticalDanger[source(percept)] <-
	.print("I found an available column! [DONE]");
	-iAmInVerticalDanger[source(percept)];
	-iShouldChangeMyVerticalPos;
	.broadcast(tell, someoneHasFixedColumn);
	+waitForOthers.

+iAmInVerticalDanger[source(percept)]
	: not ~iAmInVerticalDanger[source(percept)] & iShouldChangeMyVerticalPos <-
	moveSomewhereElseVertical;
	updatePerceptionsVertical;
	-+iAmInVerticalDanger[source(percept)].

+startHorizontalSearch <-
	.print("I will search for a good vertical location, now.");
	-shouldTestIfIShouldStartHorizontalSearch;
	+iAmInVerticalDanger[source(percept)].

+shouldTestIfIShouldStartHorizontalSearch : not startHorizontalSearch <-
	testIfIShouldStartHorizontalSearch;
	-+shouldTestIfIShouldStartHorizontalSearch.
	
+someoneHasFixedLine[source(A)] <-
	-someoneHasFixedLine;
	.print("congrats, ", A, " :)").

+~iAmInDanger[source(percept)] <-
	.print("I found an available line! [DONE]");
	-iAmInDanger[source(percept)];
	-iShouldChangeMyPos;
	.broadcast(tell, someoneHasFixedLine);
	+shouldTestIfIShouldStartHorizontalSearch.

+iAmInDanger[source(percept)]
	// Only runs this if the agent is absolutely certain that he IS in danger
	// AND he should change my position (he did not found a position available
	// in the past).
	: not ~iAmInDanger[source(percept)] & iShouldChangeMyPos <-
	moveSomewhereElse;
	updatePerceptions;
	-+iAmInDanger[source(percept)].

