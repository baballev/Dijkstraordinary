package gui;

import javax.swing.*;

public final class NewMenuItem extends JMenuItem {

	private final MainWindow mainWindow;
	
	public NewMenuItem(MainWindow mainWindow) {
		super("Nouveau");
		this.mainWindow = mainWindow;
	}
}
