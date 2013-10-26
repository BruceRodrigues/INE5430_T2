import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;
import jason.environment.grid.GridWorldModel;
import jason.environment.grid.GridWorldView;
import jason.environment.grid.Location;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import java.util.logging.Logger;


class BoardModel extends GridWorldModel {
		
	
		private Logger logger = Logger.getLogger("ChessQueens.mas2j."+Board.class.getName());
		public static final int boardSize = 8;
		
		public static final int nQueens = 3;
		
		//Choose to where the queen will move
		Random random = new Random(System.currentTimeMillis());
		
		public BoardModel() {
			super(boardSize,boardSize,nQueens);
			
			/**
			* Pos(AgID, row, column);
			*/
			
			//Choose initial location of the queens
			//Add other queens here!
			setAgPos(0,5,7); //Queen 1 -> pos (0,0)
			setAgPos(1,0,7); //Queen 2 -> pos (7,7)
			setAgPos(2,1,1); //Queen 3 ...
			//setAgPos(3,2,1);
			//setAgPos(4,5,6);
			//setAgPos(5,7,7);
			//setAgPos(6,3,4);
			//setAgPos(7,6,2);
		}
		
		
		void moveTo(int ag, int x, int y) throws Exception {
			logger.info("queen" + ag + " will move to row " + y + " column " + x); 
			setAgPos(ag,x,y);
		}
		
		//This method will check if the agent ag can kill another agent
		//return the agend id, -1 otherwise
		int canKill(int ag) {
			Location l = getAgPos(ag);
			//search for other agents
			for ( int r = 0; r < this.boardSize; r++) {
				for (int c = 0; c < this.boardSize; c++) {
					int q = getAgAtPos(c,r);
					if(q != -1) {
						if ((r != l.y && c == l.x) || (r == l.y && c != l.x)) {
								return q;	
						}
						if(Math.abs(l.x-c) == Math.abs(l.y-r)) {
							return q;	
						}
					}
				}
			}
			return -1;
		}
		
		boolean validMovement(int ag, int x, int y) {
			Location l = getAgPos(ag);
			if(getAgAtPos(x,y) == -1) {
				if(x != l.x && y != l.y) {
					if ((y != l.y && x == l.x) || (y == l.y && x != l.x)) {
						return true;				
					}
					if(Math.abs(l.x-x) == Math.abs(l.y-y)) {
						return true;
					}
				}
			}
			return false;
		}
	}
