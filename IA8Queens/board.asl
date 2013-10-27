// Agent board in project IA8Queens.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+pos(Q, X, Y) <-
	updateAgentPositionInGUI(Q, X, Y).
-pos(Q, X, Y) : pos(W, X, Y) <-
	updateAgentPositionInGUI(W, X, Y).
