/* Initial beliefs and rules */
iShouldChangeMyPos. // If I should change my line position

/* Initial goals */
!start.

/* Plans */
+!start : true <-
	updatePerceptions.

+startHorizontalSearch <-
	.print("We should probably start").

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

