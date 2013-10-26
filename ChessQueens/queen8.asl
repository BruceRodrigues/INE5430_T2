// Agent queen8 in project ChessQueens.mas2j
/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen8,X,Y).

/* Initial goals */

/*AgID =  7 */

!start.

/* Plans */

+!start : true <- move(7,1,1).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move(7,X,Y);
           !at(L).
