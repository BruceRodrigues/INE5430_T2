// Environment code for project ChessQueens.mas2j

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

public class Board extends Environment {
	
	public static final Term run = Literal.parseLiteral("run()");
	public static final Term kill = Literal.parseLiteral("canKill()");
	
	public static final Literal q1 = Literal.parseLiteral("queen(q1)");
	
    private Logger logger = Logger.getLogger("ChessQueens.mas2j."+Board.class.getName());
	
	private BoardModel model;
	private BoardView view;

    /** Called before the MAS execution with the args informed in .mas2j */
    @Override
    public void init(String[] args) {
        model = new BoardModel();
		view = new BoardView(model);
		model.setView(view);
		updatePercepts();
    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        logger.info("executing: "+action);
		
		int i = model.canKill(1);
		if(i != -1) {
			logger.info(agName+" can kill" + i);	
		}
		
		try {
			//model.moveTo(1,1,0);
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
        return true;
    }
	
	void updatePercepts() {
		Location q1Loc = model.getAgPos(0);
		
		Literal pos1 = Literal.parseLiteral("pos(q1," + q1Loc.x + "," + q1Loc.y + ")");
		
		addPercept(pos1);
	}
}

