// Agent Queen1 in project ChessQueens.mas2j

/* Initial beliefs and rules */

at(P) :- pos(P,X,Y) & pos(queen1,X,Y).

/* Initial goals */

/*AgID =  0 */

!start.

/* Plans */

+!start : true <- move(0,1,1).

+!at(L) : at(L).

+!at(L) <- ?pos(L,X,Y);
           move(0,X,Y);
           !at(L).

