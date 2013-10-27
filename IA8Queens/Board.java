// Environment code for project IA8Queens.mas2j

import jason.environment.grid.*;
import jason.asSyntax.*;
import jason.environment.*;
import java.util.logging.*;
import java.util.*;

public class Board extends Environment {
	
	class BoardModel extends GridWorldModel {
		public BoardModel(int boardSize, int numberOfQueens) {
			super(boardSize, boardSize, numberOfQueens);
		}
	}

	private final int boardSize = 8;
	private final int numberOfQueens = 8;
	private BoardModel model;
	private GridWorldView view;
    private Logger logger =
		Logger.getLogger("IA8Queens.mas2j." + Board.class.getName());

	@Override
	public void init(String[] args) {
		model = new BoardModel(boardSize, numberOfQueens);
		view = new GridWorldView(model, "8 Queens", 600);
		model.setView(view);
		view.setVisible(true);
		
		initializeAgsPositions();
		updateAgsPercept();
	}
	
	public void initializeAgsPositions() {
		Random r = new Random();
		for(int i = 0; i < numberOfQueens; i++) {
			model.setAgPos(i, r.nextInt(boardSize), r.nextInt(boardSize));
			view.update();
		}
	}
	
	public void updateAgsPercept() {
		for(int i = 0; i < numberOfQueens; i++)
			updateAgPercept(i);
	}
	
	public void updateAgPercept(int agId) {
		String agentName = "queen" + (agId + 1);
		clearPercepts(agentName);
		
		Location agentLocation = model.getAgPos(agId);
		for(int i = 0; i < numberOfQueens; i++) {
			if(i == agId) continue;
			
			Location otherAgentLocation = model.getAgPos(i);
			if(canKill(agentLocation, otherAgentLocation)) {
				Literal iAmInDanger = ASSyntax.createLiteral("iAmInDanger");
				addPercept(agentName, iAmInDanger);
				return;
			}
		}
		Literal iWillNotChangeMyPos =
			ASSyntax.createLiteral("iWillNotChangeMyPos");
		addPercept(agentName, iWillNotChangeMyPos);
	}
	
	public boolean canKill(Location l1, Location l2) {
		if(l1.y == l2.y) return true;
		return false;
	}

    @Override
    public boolean executeAction(String agName, Structure action) {
		if(action.getFunctor().equals("moveSomewhereElse")) {
			logger.info(agName + " should move.");
			return true;
		} else {
			logger.info("executing: " + action + ", but not implemented!");
		}
		return false;
    }
	
	private int agentNameToViewId(String agentName) {
		return Integer.parseInt(
			agentName.substring(agentName.length() - 1)) - 1;
	}
}

