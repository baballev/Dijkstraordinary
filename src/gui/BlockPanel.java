package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import maze.MBox;

public class BlockPanel extends JPanel implements MouseListener{ // TODO: Transform each BlockPanel in buttons
	
	private final MainWindow mainWindow;
	private final SpritePanel spritePanel;
	private final JLabel label;
		
	public BlockPanel(MainWindow mainWindow, MBox box) {
		super();
		this.mainWindow = mainWindow;
		this.add(this.spritePanel = new SpritePanel(mainWindow, box));
		this.add(this.label = new JLabel(box.getName(), JLabel.CENTER));
		this.addMouseListener(this);
	}
	public void mousePressed(MouseEvent e) {
		this.setBackground(Color.WHITE);
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
		this.spritePanel.notifyForUpdate();
	}

}

