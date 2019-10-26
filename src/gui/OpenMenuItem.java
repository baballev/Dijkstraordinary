package gui;

import javax.swing.*;

public final class OpenMenuItem extends JMenuItem {
	
	private final MainWindow mainWindow;
	
	public OpenMenuItem(MainWindow mainWindow) {
		super("Ouvrir...");
		this.mainWindow = mainWindow;
	}

}
