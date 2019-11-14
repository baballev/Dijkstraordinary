package gui.menu;

import javax.swing.*;

import gui.MainWindow;

public final class MenuBar extends JMenuBar {

	private FileMenu fileMenu;
	private ExecuteMenu executeMenu;
	private DisplayMenu displayMenu;
	
	
	public MenuBar(MainWindow mainWindow) {
		super();
		
		this.add(fileMenu = new FileMenu(mainWindow));
		this.add(executeMenu = new ExecuteMenu(mainWindow));
		this.add(displayMenu = new DisplayMenu(mainWindow));
	}
}
