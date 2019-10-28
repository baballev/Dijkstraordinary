package gui;

import java.awt.event.ActionEvent;

import javax.swing.*;

public final class SaveMenuItem extends JMenuItem {

	private final MainWindow mainWindow;
	
	public SaveMenuItem(MainWindow mainWindow) {
		super("Enregistrer...");
		this.mainWindow = mainWindow;
		this.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));
	}
	
}
