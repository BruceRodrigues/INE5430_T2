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
		public static final int boardSize = 8;
		public static final int nQueens = 3;
	    private Logger logger = Logger.getLogger(
			"ChessQueens.mas2j." + BoardModel.class.getName());
		private Random random = new Random(System.currentTimeMillis());
		
		public BoardModel() {
			super(boardSize, boardSize, nQueens);
			
			for(int i = 0; i < nQueens; i++) {
				initializeQueenPosition(i);
			}
		}
		
		private void initializeQueenPosition(int queenId) {
			boolean validPosition = false;
			int posX = 0;
			int posY = 0;
			while(!validPosition) {
				posX = random.nextInt(boardSize);
				posY = random.nextInt(boardSize);
				setAgPos(
					queenId,
					posX,
					posY
				);
				validPosition = true;
				
				// Verify if this position wasn't already taken by previous
				// queens
				for(int j = 0; j < queenId; j++) {
					if(getAgPos(queenId).x == getAgPos(j).x &&
					getAgPos(queenId).y == getAgPos(j).y) {
					   validPosition = false;
					   break;
					}
				}
			}
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
