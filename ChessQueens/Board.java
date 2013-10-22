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
	
	public static final int boardSize = 8;
	
	public static final Term run = Literal.parseLiteral("run()");
	public static final Term kill = Literal.parseLiteral("kill(queen)");
	
	public static final Literal q1 = Literal.parseLiteral("queen(q1)");
	
	public static int colorBlock = 0;

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
        logger.info("executing: "+action+", but not implemented!");
        return true;
    }

    /** Called before the end of MAS execution */
    @Override
    public void stop() {
        super.stop();
    }
	
	void updatePercepts() {
		Location q1Loc = model.getAgPos(0);
		
		Literal pos1 = Literal.parseLiteral("pos(q1," + q1Loc.x + "," + q1Loc.y + ")");
		
		addPercept(pos1);
	}
	
	class BoardModel extends GridWorldModel {
		
		
		//Choose to where the queen will move
		Random random = new Random(System.currentTimeMillis());
		
		private BoardModel() {
			super(boardSize,boardSize,2);
			
			//Choose initial location of the queens
			//Add other queens here!
			setAgPos(0,0,0); //Queen 0 -> pos (0,0)
			setAgPos(1,7,7); //Queen 1 -> pos (7,7)
		}
		
		
		void move(int x, int y) throws Exception {
			Location q = getAgPos(0);
		}
	}
	
	class BoardView extends GridWorldView {
		
		public BoardView(BoardModel model) {
			super(model, "T2 IA", 600);
			defaultFont = new Font("Arial", Font.BOLD, 18);
			setVisible(true);
			repaint();
		}
		
		public void draw(Graphics g, int x, int y, int object) {
			if(colorBlock == 0) {
				g.setColor(Color.black);
				colorBlock = 1;	
			} else {
				g.setColor(Color.white);
				colorBlock = 0;	
			}
			super.drawObstacle(g,x,y);
			drawString(g,x,y,defaultFont,"");
		}
		
		@Override
		public void drawAgent(Graphics g, int x, int y, Color  c, int id) {
				String label = "Q "+(id+1);
				c = Color.blue;
				super.drawAgent(g,x,y,c,1);
				super.drawString(g,x,y,defaultFont,label);
		}
	}
}

