package gui;

import java.awt.event.ActionEvent;

import javax.swing.*;

public final class OpenMenuItem extends JMenuItem {
	
	private final MainWindow mainWindow;
	
	public OpenMenuItem(MainWindow mainWindow) {
		super("Ouvrir...");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('O', ActionEvent.CTRL_MASK));
	}

}
