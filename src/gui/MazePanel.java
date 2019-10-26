package gui;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {

	private final MainWindow mainWindow;
	
	public MazePanel(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(256, 256));
	}
}
