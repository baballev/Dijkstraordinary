package gui;

import javax.swing.*;

public final class FileMenu extends JMenu {
	
	private final QuitMenuItem quitMenuItem;
	private final NewMenuItem newMenuItem;
	private final OpenMenuItem openMenuItem; 
	
	public FileMenu(MainWindow mainWindow) {
		super("Fichier");
		
		this.add(newMenuItem = new NewMenuItem(mainWindow));
		this.add(openMenuItem = new OpenMenuItem(mainWindow));
		
		this.addSeparator();
		this.add(quitMenuItem = new QuitMenuItem(mainWindow));
	}

}
