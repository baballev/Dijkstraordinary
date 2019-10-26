package gui;

import javax.swing.*;

public final class QuitMenuItem extends JMenuItem {
	
	private final MainWindow mainWindow;
	
	public QuitMenuItem(MainWindow mainWindow) {
		super("Quitter");
		this.mainWindow = mainWindow;
	}
}
