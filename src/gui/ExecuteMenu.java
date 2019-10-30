package gui;

import javax.swing.*;

public final class ExecuteMenu extends JMenu {
	
	private final DijkstraMenuItem dijkstraMenuItem;
	
	public ExecuteMenu(MainWindow mainWindow) {
		super("Éxecuter");
		this.add(dijkstraMenuItem = new DijkstraMenuItem(mainWindow));
	}

}
