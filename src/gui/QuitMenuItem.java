package gui;

import java.awt.event.ActionEvent;

import javax.swing.*;

public final class QuitMenuItem extends JMenuItem {
	
	private final MainWindow mainWindow;
	
	public QuitMenuItem(MainWindow mainWindow) {
		super("Quitter");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('Q', ActionEvent.CTRL_MASK));
	}
}
