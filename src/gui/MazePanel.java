package gui;

import javax.swing.*;
import maze.*;
import java.awt.*;
import java.util.ArrayList;

public class MazePanel extends JPanel {

	private final MainWindow mainWindow;
	private 	  ArrayList<SpritePanel> sprites;
	
	public MazePanel(MainWindow mainWindow) { // TODO: Check if there's a more decent way of doing this
		super();
		this.mainWindow = mainWindow;
		this.sprites = new ArrayList<SpritePanel>();
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(640, 640));
		
	} 
	
	public void notifyForUpdate(Object parameter) {
		Maze newMaze = (Maze) parameter;
		// TODO: notifyForUpdate every component, inside of them, use repaint(); 
		
		this.setLayout(new GridLayout(newMaze.getWidth(), newMaze.getHeight()));
		int i =0;
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
