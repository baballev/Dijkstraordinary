package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import maze.*;

public class SpritePanel extends JPanel {
	
	private final MainWindow mainWindow;
	private Image sprite;
	
	public SpritePanel(MainWindow mainWindow, MBox box) {
		super();
		this.mainWindow = mainWindow;
		this.sprite = new ImageIcon("data/" + box.getLabel() + "box.jpg").getImage();
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(64, 64));
		
	}
	
	public void notifyForUpdate() {
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(sprite, 0, 0, this);
	}
}
