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

	private boolean a;
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
		a = true;
		
		initializeAgsPositions();
	}
	
	public void initializeAgsPositions() {
		Random r = new Random();
		for(int i = 0; i < numberOfQueens; i++) {
			model.setAgPos(i, r.nextInt(boardSize), r.nextInt(boardSize));
			view.update();
		}
	}
	
	public void updateShouldMoveHorizontally(int agId) {
		String agentName = "queen" + (agId + 1);
		
		for(int i = 0; i < numberOfQueens - 1; i++) {
			for(int j = i + 1; j < numberOfQueens; j++) {
				Location agentLocation1 = model.getAgPos(i);
				Location agentLocation2 = model.getAgPos(j);
				if(canKill(agentLocation1, agentLocation2)) {
					return;
				}
			}
		}
		
		// This is not absolutely certain, but we have a strong feeling that we
		// can start moving.
		Literal horizontalSearchLiteral = ASSyntax.createLiteral(
			Literal.LPos, "startHorizontalSearch");
		addPercept(agentName, horizontalSearchLiteral);
	}
	
	public void updateAgPercept(int agId) {
		String agentName = "queen" + (agId + 1);
		clearPercepts(agentName);
		
		Location agentLocation = model.getAgPos(agId);
		for(int i = 0; i < numberOfQueens; i++) {
			if(i == agId) continue;
			
			Location otherAgentLocation = model.getAgPos(i);
			if(canKill(agentLocation, otherAgentLocation)) {
				Literal dangerLiteral = ASSyntax.createLiteral(
					Literal.LPos, "iAmInDanger");
				addPercept(agentName, dangerLiteral);
				return;
			}
		}
		Literal dangerLiteral = ASSyntax.createLiteral(
			Literal.LNeg, "iAmInDanger");
		addPercept(agentName, dangerLiteral);
	}	
	
	public boolean canKill(Location l1, Location l2) {
		if(l1.y == l2.y) return true;
		return false;
	}

    @Override
    public boolean executeAction(String agentName, Structure action) {
		boolean result = false;
		if(action.getFunctor().equals("moveSomewhereElse")) {
			moveSomewhereElse(agentName);
			result = true;
		} else if(action.getFunctor().equals("updatePerceptions")) {
			updateAgPercept(agentNameToViewId(agentName));
			result = true;
		} else if(action.getFunctor().equals("testIfIShouldStartHorizontalSearch")) {
			updateShouldMoveHorizontally(agentNameToViewId(agentName));
			result = true;
		} else {
			logger.info("executing: " + action + ", but not implemented!");
		}
		
		try { Thread.sleep(100); } catch(Exception e) {}
		return result;
    }
	
	private void moveSomewhereElse(String agentName) {
		int agentId = agentNameToViewId(agentName);
		Location agentLocation = model.getAgPos(agentId);
		Random r = new Random();
		if(r.nextInt(100) > 50) {
			agentLocation.y++;
		} else {
			agentLocation.y--;
		}
		
		if(agentLocation.y >= boardSize) agentLocation.y = boardSize - 1;
		if(agentLocation.y < 0) agentLocation.y = 0;
		
		model.setAgPos(agentId, agentLocation);
		// Bugfix: Force repaint all agents!
		for(int i = 0; i < numberOfQueens; i++)
			model.setAgPos(i, model.getAgPos(i));
		view.update();
	}
	
	private int agentNameToViewId(String agentName) {
		return Integer.parseInt(
			agentName.substring(agentName.length() - 1)) - 1;
	}
}

