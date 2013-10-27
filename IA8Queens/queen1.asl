/* Initial beliefs and rules */
iShouldChangeMyPos.

/* Initial goals */
!start.

/* Plans */
+!start : true <-
	updatePerceptions.

+~iAmInDanger[source(percept)] <-
	.print("I am not in danger... [DONE]");
	-iAmInDanger[source(percept)];
	-iShouldChangeMyPos.
	// Broadcast that I have my Y pos :)

+iAmInDanger[source(percept)]
	// Only runs this if the agent is absolutely certain that he IS in danger
	// AND he should change my position (he did not found a position available
	// in the past).
	: not ~iAmInDanger[source(percept)] & iShouldChangeMyPos <-
	.print("I am in danger!!");
	moveSomewhereElse;
	updatePerceptions;
	-+iAmInDanger[source(percept)].

