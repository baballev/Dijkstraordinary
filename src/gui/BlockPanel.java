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
		this.add(this.spritePanel = new SpritePanel(mainWindow, box));
		this.add(this.label = new JLabel(label, JLabel.RIGHT));
		this.mainWindow.getEditorModel().addToMazeList(box.getMaze());
	}
	
	public void notifyForUpdate() {
		this.spritePanel.notifyForUpdate();
	}

}

