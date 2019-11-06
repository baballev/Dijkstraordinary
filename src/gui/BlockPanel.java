package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import maze.MBox;

public class BlockPanel extends JPanel {
	
	private final MainWindow mainWindow;
	private final SpritePanel spritePanel;
	private final JLabel label;
	
	public BlockPanel(MainWindow mainWindow, MBox box, String label) {
		super();
		this.mainWindow = mainWindow;
		this.spritePanel = new SpritePanel(mainWindow, box);
		this.label = new JLabel(label);
	}

}
