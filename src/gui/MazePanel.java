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
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(500, 500));
		
	}
	/* 		int height = mainWindow.getMazeModel().getMaze().getHeight();
		int width = mainWindow.getMazeModel().getMaze().getWidth();
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width*32, height*32));
		
		MBox[][] boxes = mainWindow.getMazeModel().getMaze().getLabyrinthe();
		for (MBox[] line : boxes) {
			for (MBox box : line) {
				
			}
		} */ 
	
	
	public void notifyForUpdate() {
		// TODO: notifyForUpdate every component, inside of them, use repaint(); 
		//this.setLayout(new GridLayout());
	}
}
