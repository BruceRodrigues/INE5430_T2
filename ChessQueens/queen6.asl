// Agent queen6 in project ChessQueens.mas2j

/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen6,X,Y).

/* Initial goals */

/*AgID =  5 */

!start.

/* Plans */

+!start : true <- move(5,1,1).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move(5,X,Y);
           !at(L).
