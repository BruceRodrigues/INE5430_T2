// Agent queen5 in project ChessQueens.mas2j

/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen5,X,Y).

/* Initial goals */

/*AgID =  4 */

!start.

/* Plans */

+!start : true <- move(4,1,1).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move(4,X,Y);
           !at(L).
