// Agent queen4 in project ChessQueens.mas2j

/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen4,X,Y).

/* Initial goals */

/*AgID =  3 */

!start.

/* Plans */

+!start : true <- move(3,1,1).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move(3,X,Y);
           !at(L).

