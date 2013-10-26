// Agent Queen2 in project ChessQueens.mas2j

/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen2,X,Y).

/* Initial goals */

/*AgID =  1 */

!start.

/* Plans */

+!start : true <- move(1,1,1).

+!at(L) : at(L).
+!at(L) <- ?pos(L,X,Y);
           move(1,X,Y);
           !at(L).
