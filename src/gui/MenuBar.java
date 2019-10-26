package gui;

import javax.swing.*;

public final class MenuBar extends JMenuBar {

	private FileMenu fileMenu;
	
	public MenuBar(MainWindow mainWindow) {
		super();
		
		add(fileMenu = new FileMenu(mainWindow));
	}
}
