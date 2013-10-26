// Agent queen7 in project ChessQueens.mas2j

/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen7,X,Y).

/* Initial goals */

/*AgID =  6 */

!start.

/* Plans */

+!start : true <- move(6,1,1).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move(6,X,Y);
           !at(L).
