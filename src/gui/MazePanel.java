package gui;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

	private final MainWindow mainWindow;
	
	public MazePanel(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
		int height = mainWindow.getMazeModel().getMaze().getHeight();
		int width = mainWindow.getMazeModel().getMaze().getWidth();
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(width*32, height*32));
		
	}
	
	public void notifyForUpdate() {
		// TODO: notifyForUpdate every component, inside of them, use repaint(); 
		//this.setLayout(new GridLayout());
	}
}
