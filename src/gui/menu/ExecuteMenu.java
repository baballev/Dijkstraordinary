package gui.menu;

import javax.swing.*;

import gui.MainWindow;

public final class ExecuteMenu extends JMenu {
	
	private final DijkstraMenuItem dijkstraMenuItem;
	
	public ExecuteMenu(MainWindow mainWindow) {
		super("�xecuter");
		this.add(dijkstraMenuItem = new DijkstraMenuItem(mainWindow));
	}

}
