package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import maze.MBox;

public class ClickableSpritePanel extends SpritePanel implements MouseListener{
	
	private final MainWindow mainWindow;
	private final int x;
	private final int y;
	
	public ClickableSpritePanel(MainWindow mainWindow, MBox box, int x, int y) {
		super(mainWindow, box);
		this.mainWindow = mainWindow;
		this.x = x;
		this.y = y;
		
		this.addMouseListener(this);
	}
	
	public void mousePressed(MouseEvent e) {
		this.mainWindow.getMazeModel().changeMBox(this.x, this.y);
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
}
