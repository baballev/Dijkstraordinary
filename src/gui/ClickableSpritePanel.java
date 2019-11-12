package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import maze.MBox;

public class ClickableSpritePanel extends SpritePanel implements MouseListener{

	public ClickableSpritePanel(MainWindow mainWindow, MBox box) {
		super(mainWindow, box);
		this.addMouseListener(this);
	}
	
	public void mousePressed(MouseEvent e) {
		//this.mainWindow.getMazeModel().changeMBox(this.getX(), this.getY());
		System.out.println(this.getAlignmentX());
		
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
