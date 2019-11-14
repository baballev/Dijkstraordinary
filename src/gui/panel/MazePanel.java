package gui.panel;

import javax.swing.*;

import gui.MainWindow;
import maze.*;
import java.awt.*;
import java.util.ArrayList;

public class MazePanel extends JPanel {

	private final MainWindow mainWindow;
	private 	  ArrayList<SpritePanel> sprites;
	
	public MazePanel(MainWindow mainWindow) { 
		super();
		this.mainWindow = mainWindow;
		this.sprites = new ArrayList<SpritePanel>();
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(400, 400));
	} 
	
	public void notifyForUpdate(Object parameter) {
		this.removeAll();
		Maze newMaze = (Maze) parameter;
		sprites.removeAll(sprites); // Empty the arraylist
		this.setLayout(new GridLayout(newMaze.getWidth(), newMaze.getHeight()));
		this.setPreferredSize(new Dimension(64*newMaze.getWidth(), 64*newMaze.getHeight()));
		this.mainWindow.setMinimumSize(new Dimension(64*newMaze.getWidth() + 200, 64*newMaze.getHeight()+ 50));
		int x = 0;
		int y = 0;
		for(MBox[] line : newMaze.getLabyrinthe()) {
			for(MBox box : line) {
				SpritePanel sprite = new ClickableSpritePanel(this.mainWindow, box, x, y);
				sprites.add(sprite);
				this.add(sprite);
				x++;
			}
			x = 0;
			y++;
		}
		for (SpritePanel sprite : sprites) {
			sprite.notifyForUpdate();
		}
	}
}
