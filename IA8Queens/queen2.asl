/* Initial beliefs and rules */
/* I have no assumptions about the world. */

/* Initial goals */

/* Plans */
+iAmInDanger : not iWillNotChangeMyPos <-
	moveSomewhereElse;
	-iAmInDanger.

+iWillNotChangeMyPos <-
	// Broadcast that I have my Y pos :)
	.print("..").
