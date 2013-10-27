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
import java.util.Random;

public class Board extends Environment {
	
    private Logger logger = Logger.getLogger(
		"ChessQueens.mas2j." + Board.class.getName());
	private Random random = new Random(System.currentTimeMillis());
	private BoardModel model;
	private BoardView view;
	
	class ICanKillOtherQueens {}

    @Override
    public void init(String[] args) {
        model = new BoardModel();
		view = new BoardView(model);
		model.setView(view);
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info(agName + " executing: " + action);
		boolean kill = true;
		
		/*
		while(kill) {
			kill = false;
			for (int queen = 0; queen < model.nQueens; queen++) {
				int i = model.canKill(queen);
				if(i != -1) {
					logger.info(agName + " can kill" + " queen" + (i+1));
					kill = true;
					try {
						int x, y;
						do {
							x = random.nextInt(model.boardSize);
							y = random.nextInt(model.boardSize);
						} while(!model.validMovement(i, x, y));
						model.moveTo(i,x,y);
					} catch (Exception e) {
						e.printStackTrace();	
					}
				}
			}
		}
		*/
        return true;
    }
}

