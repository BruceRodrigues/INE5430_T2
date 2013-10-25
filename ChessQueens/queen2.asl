// Agent Queen2 in project ChessQueens.mas2j

/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen1,X,Y).

/* Initial goals */

!start.

/* Plans */

+!start : true <- move(1,1,1).

+!at(L) : at(L).
