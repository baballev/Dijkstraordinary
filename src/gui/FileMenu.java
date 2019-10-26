package gui;

import javax.swing.*;

public final class FileMenu extends JMenu {
	
	private final QuitMenuItem quitMenuItem;
	
	public FileMenu(MainWindow mainWindow) {
		super("Fichier");
		
		add(quitMenuItem = new QuitMenuItem(mainWindow));
	}

}
