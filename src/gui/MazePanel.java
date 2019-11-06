package gui;

import javax.swing.*;
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
		this.setPreferredSize(new Dimension(640, 640));
	} 
	
	public void notifyForUpdate(Object parameter) {
		this.removeAll();
		Maze newMaze = (Maze) parameter;
		sprites.removeAll(sprites); // Empty the arraylist
		this.setLayout(new GridLayout(newMaze.getWidth(), newMaze.getHeight()));
		this.setPreferredSize(new Dimension(64*newMaze.getWidth(), 64*newMaze.getHeight()));
		this.mainWindow.setMinimumSize(new Dimension(64*newMaze.getWidth() + 200, 64*newMaze.getHeight()+ 50));
		for(MBox[] line : newMaze.getLabyrinthe()) {
			for(MBox box : line) {
				SpritePanel sprite = new SpritePanel(this.mainWindow, box);
				sprites.add(sprite);
				this.add(sprite);
			}
		}
		for (SpritePanel sprite : sprites) {
			sprite.notifyForUpdate();
		}
	}
}
