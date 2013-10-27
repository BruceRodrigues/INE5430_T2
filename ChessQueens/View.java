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
		
		public BoardView(BoardModel model) {
			super(model, "T2 IA - 8 Queens", 600);
			defaultFont = new Font("Arial", Font.BOLD, 18);
			setVisible(true);
			repaint();
		}
		
		@Override
		public void drawAgent(Graphics g, int x, int y, Color  c, int id) {
				String label = "Queen " + id;
				c = Color.blue;
				super.drawAgent(g, x, y, c, id);
		}
	}
