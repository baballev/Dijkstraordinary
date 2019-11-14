package gui.panel;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MainWindow;
import maze.MBox;

public class BlockPanel extends JPanel implements MouseListener{ 
	
	private final MainWindow mainWindow;
	private final SpritePanel spritePanel;
	private final JLabel label;
	private final MBox mBox;
		
	public BlockPanel(MainWindow mainWindow, MBox box) {
		super();
		this.mainWindow = mainWindow;
		this.mBox = box;
		this.add(this.spritePanel = new SpritePanel(mainWindow, this.mBox));
		this.add(this.label = new JLabel(box.getName(), JLabel.CENTER));
		this.addMouseListener(this);
	}
	public void mousePressed(MouseEvent e) {
		this.setBackground(Color.GRAY);
		this.mainWindow.getEditorModel().setClicked(this.mBox);
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	
	public void notifyForUpdate() {
		this.setBackground(Color.WHITE);
		this.spritePanel.notifyForUpdate();
	}

}

