// Agent queen3 in project ChessQueens.mas2j

/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen3,X,Y).

/* Initial goals */

/*AgID =  2 */

!start.

/* Plans */

+!start : true <- move(2,1,1).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move(2,X,Y);
           !at(L).
