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

class BoardView extends GridWorldView {
		
	
		public static int colorBlock = 0;
	
	
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
				String label = "Queen"+id;
				c = Color.blue;
				super.drawAgent(g,x,y,c,id);
				//super.drawString(g,x,y,defaultFont,label);
		}
	}
